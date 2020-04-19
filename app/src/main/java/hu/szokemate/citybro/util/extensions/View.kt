package hu.szokemate.citybro.util.extensions

import android.view.View
import android.view.ViewGroup
import androidx.annotation.DimenRes


fun View.setMargin(
    @DimenRes left: Int? = null,
    @DimenRes top: Int? = null,
    @DimenRes right: Int? = null,
    @DimenRes bottom: Int? = null
) {
    if (left != null) {
        layoutParams<ViewGroup.MarginLayoutParams> {
            leftMargin = resources.getDimension(left).toInt()
        }
    }

    if (top != null) {
        layoutParams<ViewGroup.MarginLayoutParams> {
            topMargin = resources.getDimension(top).toInt()
        }
    }

    if (right != null) {
        layoutParams<ViewGroup.MarginLayoutParams> {
            rightMargin = resources.getDimension(right).toInt()
        }
    }

    if (bottom != null) {
        layoutParams<ViewGroup.MarginLayoutParams> {
            bottomMargin = resources.getDimension(bottom).toInt()
        }
    }
}

private inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
    if (layoutParams is T) block(layoutParams as T)
}


