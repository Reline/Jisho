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

package io.github.reline.jishodb.dbmodels

import io.realm.RealmModel
import io.realm.annotations.RealmClass

// Issue #14: data is lost when parceled
//    private Object dbpedia; // String or boolean

@RealmClass
open class Attribution : RealmModel {
    var isJmdict: Boolean = false
    var isJmnedict: Boolean = false

    //    public Object isDbpedia() {
    //        return dbpedia;
    //    }

}