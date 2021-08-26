package com.bobby.cloner.core.presentation.listener

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by Bobby Irawan on 25/08/21.
 */
class EditTextListener(private val onTextChange: (String) -> Unit): TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        //Do nothing
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        val query = p0.toString()
        onTextChange(query)
    }

    override fun afterTextChanged(p0: Editable?) {
        //Do nothing
    }
}
