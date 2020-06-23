package com.github.reline.jisho.persistence

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import okio.buffer
import okio.sink
import okio.source
import timber.log.Timber
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.nio.ByteBuffer
import java.util.concurrent.locks.ReentrantLock

class SQLiteCopyOpenHelper(
        private val context: Context,
        private val copyFromAssetPath: String,
        private val databaseVersion: Int,
        private val delegate: SupportSQLiteOpenHelper
) : SupportSQLiteOpenHelper by delegate {

    private var verified = false

    @Synchronized
    override fun getWritableDatabase(): SupportSQLiteDatabase? {
        if (!verified) {
            verifyDatabaseFile()
            verified = true
        }
        return delegate.writableDatabase
    }

    @Synchronized
    override fun getReadableDatabase(): SupportSQLiteDatabase? {
        if (!verified) {
            verifyDatabaseFile()
            verified = true
        }
        return delegate.readableDatabase
    }

    @Synchronized
    override fun close() {
        delegate.close()
        verified = false
    }

    private fun verifyDatabaseFile() {
        val databaseName = databaseName
        val databaseFile: File = context.getDatabasePath(databaseName)
        val copyLock = ReentrantLock()
        try {
            copyLock.lock()
            if (!databaseFile.exists()) {
                try {
                    // No database file found, copy and be done.
                    copyDatabaseFile(databaseFile)
                    return
                } catch (e: IOException) {
                    throw RuntimeException("Unable to copy database file.", e)
                }
            }
            // A database file is present, check if we need to re-copy it.
            val currentVersion = try {
                readVersion(databaseFile)
            } catch (e: IOException) {
                Timber.w(e, "Unable to read database version.")
                return
            }
            if (currentVersion == databaseVersion) {
                return
            }
            // Always overwrite, we won't support upgrade migrations
            if (context.deleteDatabase(databaseName)) {
                try {
                    copyDatabaseFile(databaseFile)
                } catch (e: IOException) {
                    // We are more forgiving copying a database on a destructive migration since
                    // there is already a database file that can be opened.
                    Timber.w(e, "Unable to copy database file.")
                }
            } else {
                Timber.w("Failed to delete database file ($databaseName) for a copy destructive migration.")
            }
        } finally {
            copyLock.unlock()
        }
    }

    /**
     * Reads the user version number out of the database header from the given file.
     *
     * @param databaseFile the database file.
     * @return the database version
     * @throws IOException if something goes wrong reading the file, such as bad database header or
     * missing permissions.
     *
     * @see <a href="https://www.sqlite.org/fileformat.html#user_version_number">User Version
     * Number</a>.
     */
    @Throws(IOException::class)
    private fun readVersion(databaseFile: File): Int {
        return FileInputStream(databaseFile).channel.use { input ->
            input.tryLock(60, 4, true)
            input.position(60)
            val buffer = ByteBuffer.allocate(4)
            val read = input.read(buffer)
            if (read != 4) {
                throw IOException("Bad database header, unable to read 4 bytes at offset 60")
            }
            buffer.rewind()
            buffer.int // ByteBuffer is big-endian by default
        }
    }

    @Throws(IOException::class)
    private fun copyDatabaseFile(destinationFile: File) {
        // An intermediate file is used so that we never end up with a half-copied database file
        // in the internal directory.
        val intermediateFile = File.createTempFile(
                "sqlite-copy-helper", ".tmp", context.cacheDir)
        intermediateFile.deleteOnExit()
        context.assets.open(copyFromAssetPath).source().use { a ->
            intermediateFile.sink().buffer().use { b -> b.writeAll(a) }
        }
        val parent = destinationFile.parentFile
        if (parent != null && !parent.exists() && !parent.mkdirs()) {
            throw IOException("Failed to create directories for "
                    + destinationFile.absolutePath)
        }
        if (!intermediateFile.renameTo(destinationFile)) {
            throw IOException("Failed to move intermediate file ("
                    + intermediateFile.absolutePath + ") to destination ("
                    + destinationFile.absolutePath + ").")
        }
    }

    /**
     * Implementation of {@link SupportSQLiteOpenHelper.Factory} that creates
     * {@link SQLiteCopyOpenHelper}.
     */
    class Factory(
            private val context: Context,
            private val copyFromAssetsPath: String,
            private val delegate: SupportSQLiteOpenHelper.Factory
    ) : SupportSQLiteOpenHelper.Factory {
        override fun create(config: SupportSQLiteOpenHelper.Configuration): SupportSQLiteOpenHelper {
            return SQLiteCopyOpenHelper(
                    context,
                    copyFromAssetsPath,
                    config.callback.version,
                    delegate.create(config)
            )
        }
    }
}