package hu.szokemate.citybro.util.extensions

import android.content.Context
import android.util.TypedValue
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

fun Context.getColorViaAttribute(attributeId: Int): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attributeId, typedValue, true)
    return typedValue.data
}

fun Context.getColorCompat(@ColorRes color: Int): Int {
    return ContextCompat.getColor(this, color)
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.toast(@StringRes messageRes: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, messageRes, duration).show()
}
