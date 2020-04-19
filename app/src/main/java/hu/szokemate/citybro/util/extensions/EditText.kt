package hu.szokemate.citybro.util.extensions

import android.widget.EditText

/**
 * Extension property for [EditText] to get it's value without whitespaces.
 */
inline val EditText.trimmedText: String
    get() = text.toString().trim()
