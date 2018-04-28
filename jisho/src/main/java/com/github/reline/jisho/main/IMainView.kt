/*
 * Copyright 2017 Nathaniel Reline
 *
 * This work is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/4.0/ or
 * send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 */

package com.github.reline.jisho.main

import com.github.reline.jisho.models.Word

interface IMainView {
    fun updateResults(results: List<Word>)
    fun hideNoMatchView()
    fun showNoMatchView()
    fun hideLogo()
    fun hideProgressBar()
    fun showProgressBar()
    fun hideKeyboard()
}
