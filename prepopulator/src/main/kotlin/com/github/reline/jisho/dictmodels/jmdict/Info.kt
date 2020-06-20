/*
 * Copyright 2017 Nathaniel Reline
 *
 * This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or
 * send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.github.reline.jisho.dictmodels.jmdict

/**
 * The following entity codes are used for common elements within the
various information fields.
 */
object Info {

    // todo: parse these from the xml doctype properly
    // https://xmlwriter.net/xml_guide/entity_declaration.shtml
    val ENTITIES = hashMapOf(
            Pair("verb", "Verb of any type"),
            Pair("adjective", "Adjective of any type"),
            Pair("counter", "Counter words"),
            Pair("abbr", "Abbreviation"),
            Pair("adj-f", "Noun or verb acting prenominally"),
            Pair("adj-i", "I-adjective"),
            Pair("adj-ix", "Adjective (keiyoushi) - yoi/ii class"),
            Pair("adj-kari", "Kari adjective (archaic)"),
            Pair("adj-ku", "Ku-adjective (archaic)"),
            Pair("adj-na", "Na-adjective"),
            Pair("adj-nari", "Archaic/formal form of na-adjective"),
            Pair("adj-no", "No-adjective"),
            Pair("adj-pn", "Pre-noun adjectival"),
            Pair("adj-shiku", "Shiku adjective (archaic)"),
            Pair("adj-t", "Taru-adjective"),
            Pair("adv", "Adverb (fukushi)"),
            Pair("adv-to", "Adverb taking the 'to' particle"),
            Pair("anat", "Anatomical term"),
            Pair("ant", "Antonym"),
            Pair("arch", "Archaism"),
            Pair("archit", "Architecture term"),
            Pair("astron", "Astronomy term"),
            Pair("ateji", "Ateji (phonetic) reading"),
            Pair("aux", "Auxiliary"),
            Pair("aux-adj", "Auxiliary adjective"),
            Pair("aux-v", "Auxiliary verb"),
            Pair("baseb", "Baseball term"),
            Pair("biol", "Biology term"),
            Pair("bot", "Botany term"),
            Pair("bus", "Business term"),
            Pair("chem", "Chemistry term"),
            Pair("chn", "Children's language"),
            Pair("col", "Colloquialism"),
            Pair("comp", "Computer terminology"),
            Pair("cop-da", "copula"),
            Pair("conj", "Conjunction"),
            Pair("ctr", "Counter"),
            Pair("derog", "Derogatory"),
            Pair("eK", "Exclusively kanji"),
            Pair("econ", "Economics term"),
            Pair("ek", "Exclusively kana"),
            Pair("engr", "Engineering term"),
            Pair("equ", "Equivalent"),
            Pair("ex", "Usage example"),
            Pair("exp", "Expressions (phrases, clauses, etc.)"),
            Pair("fam", "Familiar language"),
            Pair("fem", "Female term or language"),
            Pair("fig", "Figuratively"),
            Pair("finc", "Finance term"),
            Pair("food", "Food term"),
            Pair("geol", "Geology, etc. term"),
            Pair("geom", "Geometry term"),
            Pair("gikun", "Gikun (meaning as reading) or jukujikun (special kanji reading)"),
            Pair("go", "On reading"),
            Pair("hob", "Hokkaido dialect"),
            Pair("hon", "Honorific or respectful (sonkeigo)"),
            Pair("hum", "Humble (kenjougo)"),
            Pair("iK", "Irregular kanji usage"),
            Pair("id", "Idiomatic expression"),
            Pair("ik", "Irregular kana usage"),
            Pair("int", "Interjection"),
            Pair("io", "Irregular okurigana usage"),
            Pair("iv", "Irregular verb"),
            Pair("jlpt-n1", "JLPT N1"),
            Pair("jlpt-n2", "JLPT N2"),
            Pair("jlpt-n3", "JLPT N3"),
            Pair("jlpt-n4", "JLPT N4"),
            Pair("jlpt-n5", "JLPT N5"),
            Pair("joc", "Jocular, humorous term"),
            Pair("jouyou", "Approved reading for jouyou kanji"),
            Pair("kan", "On reading"),
            Pair("ksb", "Kansai dialect"),
            Pair("ktb", "Kantou dialect"),
            Pair("kun", "Kun reading"),
            Pair("kvar", "Kanji variant"),
            Pair("kyb", "Kyoto dialect"),
            Pair("kyu", "Kyuushuu dialect"),
            Pair("law", "Law, etc. term"),
            Pair("ling", "Linguistics terminology"),
            Pair("lit", "Literaly"),
            Pair("m-sl", "Manga slang"),
            Pair("mahj", "Mahjong term"),
            Pair("male", "Male term or language"),
            Pair("male-sl", "Male slang"),
            Pair("math", "Mathematics"),
            Pair("med", "Medicine, etc. term"),
            Pair("mil", "Military"),
            Pair("music", "Music term"),
            Pair("n", "Noun"),
            Pair("n-adv", "Adverbial noun"),
            Pair("n-pr", "Proper noun"),
            Pair("n-suf", "Noun - used as a suffix"),
            Pair("n-pref", "Noun - used as a prefix"),
            Pair("n-t", "Temporal noun"),
            Pair("nab", "Nagano dialect"),
            Pair("name", "Name reading (nanori)"),
            Pair("num", "Numeric"),
            Pair("oK", "Out-dated kanji"),
            Pair("obs", "Obsolete term"),
            Pair("obsc", "Obscure term"),
            Pair("oik", "Old or irregular kana form"),
            Pair("ok", "Out-dated or obsolete kana usage"),
            Pair("on", "On reading"),
            Pair("on-mim", "Onomatopoeic or mimetic word"),
            Pair("osb", "Osaka dialect"),
            Pair("physics", "Physics terminology"),
            Pair("pn", "Pronoun"),
            Pair("poet", "Poetical term"),
            Pair("pol", "Polite (teineigo)"),
            Pair("pref", "Prefix"),
            Pair("proverb", "Proverb"),
            Pair("prt", "Particle"),
            Pair("rad", "Reading used as name of radical"),
            Pair("rare", "Rare"),
            Pair("rkb", "Ryuukyuu dialect"),
            Pair("see", "See also"),
            Pair("sens", "Sensitive"),
            Pair("shogi", "Shogi term"),
            Pair("sl", "Slang"),
            Pair("sports", "Sports term"),
            Pair("suf", "Suffix"),
            Pair("sumo", "Sumo term"),
            Pair("syn", "Synonym"),
            Pair("thb", "Touhoku dialect"),
            Pair("tou", "On reading"),
            Pair("tsb", "Tosa dialect"),
            Pair("tsug", "Tsugaru dialect"),
            Pair("uK", "Usually written using kanji alone"),
            Pair("uk", "Usually written using kana alone"),
            Pair("unc", "unclassified"),
            Pair("v-unspec", "Verb unspecified"),
            Pair("v1", "Ichidan verb"),
            Pair("v1-s", "Ichidan verb - kureru special class"),
            Pair("v2a-s", "Nidan verb with u ending (archaic)"),
            Pair("v2b-k", "Nidan verb (upper class) with bu ending (archaic)"),
            Pair("v2b-s", "Nidan verb (lower class) with bu ending (archaic)"),
            Pair("v2d-k", "Nidan verb (upper class) with dzu ending (archaic)"),
            Pair("v2d-s", "Nidan verb (lower class) with dzu ending (archaic)"),
            Pair("v2g-k", "Nidan verb (upper class) with gu ending (archaic)"),
            Pair("v2g-s", "Nidan verb (lower class) with gu ending (archaic)"),
            Pair("v2h-k", "Nidan verb (upper class) with hu/fu ending (archaic)"),
            Pair("v2h-s", "Nidan verb (lower class) with hu/fu ending (archaic)"),
            Pair("v2k-k", "Nidan verb (upper class) with ku ending (archaic)"),
            Pair("v2k-s", "Nidan verb (lower class) with ku ending (archaic)"),
            Pair("v2m-k", "Nidan verb (upper class) with mu ending (archaic)"),
            Pair("v2m-s", "Nidan verb (lower class) with mu ending (archaic)"),
            Pair("v2n-s", "Nidan verb (lower class) with nu ending (archaic)"),
            Pair("v2r-k", "Nidan verb (upper class) with ru ending (archaic)"),
            Pair("v2r-s", "Nidan verb (lower class) with ru ending (archaic)"),
            Pair("v2s-s", "Nidan verb (lower class) with su ending (archaic)"),
            Pair("v2t-k", "Nidan verb (upper class) with tsu ending (archaic)"),
            Pair("v2t-s", "Nidan verb (lower class) with tsu ending (archaic)"),
            Pair("v2w-s", "Nidan verb (lower class) with u ending and we conjugation (archaic)"),
            Pair("v2y-k", "Nidan verb (upper class) with yu ending (archaic)"),
            Pair("v2y-s", "Nidan verb (lower class) with yu ending (archaic)"),
            Pair("v2z-s", "Nidan verb (lower class) with zu ending (archaic)"),
            Pair("v4b", "Yodan verb with bu ending (archaic)"),
            Pair("v4g", "Yodan verb with gu ending (archaic)"),
            Pair("v4h", "Yodan verb with hu/fu ending (archaic)"),
            Pair("v4k", "Yodan verb with ku ending (archaic)"),
            Pair("v4m", "Yodan verb with mu ending (archaic)"),
            Pair("v4n", "Yodan verb with nu ending (archaic)"),
            Pair("v4r", "Yodan verb with ru ending (archaic)"),
            Pair("v4s", "Yodan verb with su ending (archaic)"),
            Pair("v4t", "Yodan verb with tsu ending (archaic)"),
            Pair("v5aru", "Godan verb - -aru special class"),
            Pair("v5b", "Godan verb with bu ending"),
            Pair("v5g", "Godan verb with gu ending"),
            Pair("v5k", "Godan verb with ku ending"),
            Pair("v5k-s", "Godan verb - Iku/Yuku special class"),
            Pair("v5m", "Godan verb with mu ending"),
            Pair("v5n", "Godan verb with nu ending"),
            Pair("v5r", "Godan verb with ru ending"),
            Pair("v5r-i", "Godan verb with ru ending (irregular verb)"),
            Pair("v5s", "Godan verb with su ending"),
            Pair("v5t", "Godan verb with tsu ending"),
            Pair("v5u", "Godan verb with u ending"),
            Pair("v5u-s", "Godan verb with u ending (special class)"),
            Pair("v5uru", "Godan verb - Uru old class verb (old form of Eru)"),
            Pair("v5z", "Goden verb with zu ending"),
            Pair("vi", "Intransitive verb"),
            Pair("vk", "Kuru verb - special class"),
            Pair("vn", "Irregular nu verb"),
            Pair("vr", "Irregular ru verb, plain form ends with -ri"),
            Pair("vs", "Noun or participle which takes the aux. verb suru"),
            Pair("vs-c", "Su verb - precursor to the modern suru"),
            Pair("vs-i", "Suru verb - irregular"),
            Pair("vs-s", "Suru verb - special class"),
            Pair("vt", "Transitive verb"),
            Pair("yoji", "yojijukugo"),
            Pair("vulg", "Vulgar"),
            Pair("vz", "Ichidan verb - zuru verb (alternative form of -jiru verbs)"),
            Pair("zool", "Zoology term"),
            Pair("Buddh", "Buddhist term"),
            Pair("MA", "Martial arts term"),
            Pair("Shinto", "Shinto term"),
            Pair("X", "Rude or X-rated term (not displayed in educational software)"),
            Pair("wasei", "Wasei, word made in Japan"))


    fun get(entity: String): String {
        val e = entity.removePrefix("&").removeSuffix(";")
        return ENTITIES[e] ?: throw NullPointerException("Info not found for entity $entity")
    }
}