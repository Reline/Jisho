package com.github.reline.jisho.compression

import com.github.reline.jisho.text.EUC_JP
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath
import okio.buffer
import okio.gzip
import okio.openZip
import org.slf4j.LoggerFactory
import java.io.IOException
import java.nio.charset.Charset

private val logger by lazy { LoggerFactory.getLogger("compress-logger") }

private val ROOT = "/".toPath()

typealias FileSystemPath = Pair<FileSystem, Path>

/**
 * Extract all compressed files in the given [paths].
 *
 * Zip files are expected to be from Monash.
 * The Monash zip file contents are all in EUC-JP format AKA:
 * - EUC-JP
 * - csEUCPkdFmtjapanese
 * - x-euc-jp
 * - Extended_UNIX_Code_Packed_Format_for_Japanese
 * - eucjis
 * - euc_jp
 * - eucjp.kt
 * - eucjp.kt
 */
@Throws(IOException::class)
fun FileSystem.extract(
    vararg paths: Path,
    at: FileSystemPath,
    // todo: configure charsets properly
    charset: Charset = Charsets.EUC_JP,
) = buildList {
    paths.forEach {
        when (it.toFile().extension) {
            "zip" -> addAll(extractZip(it, at, charset))
            "gz" -> add(extractGzip(it, at))
        }
    }
    logger.debug("Extraction complete")
}

@Throws(IOException::class)
fun FileSystem.extractZip(
    zipPath: Path,
    destination: FileSystemPath,
    charset: Charset = Charsets.UTF_8,
): List<Path> {
    val (fileSystem, base) = destination
    if (!fileSystem.exists(base)) {
        fileSystem.createDirectories(base, mustCreate = true)
    }
    val zip = openZip(zipPath)
    logger.info("Extracting $zipPath to $base")
    return zip.list(ROOT).map { path ->
        val file = base/path.name
        // todo: inject logger
        logger.debug("Extracting $path to $base")
        zip.read(path) {
            fileSystem.write(file) {
                // todo: investigate performance
                // todo: inject charset
                writeUtf8(readString(charset))
            }
        }
        return@map file
    }
}

@Throws(IOException::class)
fun FileSystem.extractGzip(gzip: Path, destination: FileSystemPath): Path {
    val (fileSystem, base) = destination
    if (!fileSystem.exists(base)) {
        fileSystem.createDirectories(base, mustCreate = true)
    }
    logger.info("Extracting $gzip to $base")
    val file = base/gzip.toFile().nameWithoutExtension
    source(gzip).gzip().buffer().use { source ->
        fileSystem.write(file) {
            source.readAll(this)
        }
    }
    return file
}
