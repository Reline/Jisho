/*
 * Copyright 2017 Nathaniel Reline
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.reline.jishodb.dictmodels

import com.tickaroo.tikxml.annotation.TextContent
import com.tickaroo.tikxml.annotation.Xml

/**
 *  This and the equivalent re_pri field are provided to record
    information about the relative priority of the entry,  and consist
    of codes indicating the word appears in various references which
    can be taken as an indication of the frequency with which the word
    is used. This field is intended for use either by applications which
    want to concentrate on entries of  a particular priority, or to
    generate subset files.
    The current values in this field are: {@link Priority}


    The reason both the kanji and reading elements are tagged is because
    on occasions a priority is only associated with a particular
    kanji/reading pair.
 */
@Xml(name = "ke_pri")
open class KanjiPriority {

    @TextContent
    lateinit var value: String

    fun isCommon() = Priority.isCommon(value)
}