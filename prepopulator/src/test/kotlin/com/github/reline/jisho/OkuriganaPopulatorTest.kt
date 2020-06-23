package com.github.reline.jisho

import com.github.reline.jisho.dictmodels.jmdict.Entry
import com.github.reline.jisho.dictmodels.okurigana.OkuriganaEntry
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import java.io.File

class OkuriganaPopulatorTest {
    companion object {
        private val testDbPath = "./build/test/jmdict.sqlite"
        private lateinit var entries: List<Entry>
        private lateinit var okurigana: List<OkuriganaEntry>

        @BeforeClass
        @JvmStatic
        fun setupSuite() {
            entries = DictionaryPopulator.extractDictionary(File("./build/dict/JMdict_e.xml")).entries +
                    DictionaryPopulator.extractDictionary(File("./build/dict/JMnedict.xml")).entries
            okurigana = OkuriganaPopulator.extractOkurigana(File("./build/dict/JmdictFurigana.json")) +
                    OkuriganaPopulator.extractOkurigana(File("./build/dict/JmnedictFurigana.json"))
        }
    }

    @Before
    fun setup() {
        val db = File(testDbPath)
        db.parentFile.mkdirs()
        db.delete()
        db.createNewFile()
        databasePath = testDbPath
    }

    @After
    fun teardown() {
        File(testDbPath).delete()
    }

    @Test
    fun smokeTest() {
        DictionaryPopulator.insertEntries(entries)
        OkuriganaPopulator.insertOkurigana(okurigana)
    }
}