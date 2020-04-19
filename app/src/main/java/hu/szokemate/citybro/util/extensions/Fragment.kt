@file:Suppress("NOTHING_TO_INLINE")

package hu.szokemate.citybro.util.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import hu.szokemate.citybro.R
import kotlinx.android.synthetic.main.common_dialog.view.*

private const val DIALOG_DISPLAY_CONTENT_VIEW = 1

inline fun Fragment.hideKeyboard() {
    val view = view ?: return
    val imm = ContextCompat.getSystemService(requireContext(), InputMethodManager::class.java)
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}

inline fun Fragment.showKeyboard(view: View) {
    val imm = ContextCompat.getSystemService(requireContext(), InputMethodManager::class.java)
    imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

fun Fragment.showCommonDialog(
    message: CharSequence = "",
    title: String? = null,
    contentView: View? = null,
    @StringRes positiveButtonText: Int? = null,
    positiveButtonAction: (() -> Unit)? = null,
    @StringRes negativeButtonText: Int? = null,
    negativeButtonAction: (() -> Unit)? = null,
    isCancelable: Boolean = true
): androidx.appcompat.app.AlertDialog {
    val context = this.requireContext()

    val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(context)

    val dialogView = LayoutInflater.from(context).inflate(R.layout.common_dialog, null)

    if (title != null) {
        dialogView.dialogTitleText.text = title
    } else {
        dialogView.dialogTitleText.isVisible = false
    }
    if (contentView == null) {
        dialogView.dialogMessageText.text = message
    } else {
        dialogView.dialogContentContainer.addView(contentView)
        dialogView.dialogContentViewFlipper.displayedChild = DIALOG_DISPLAY_CONTENT_VIEW
    }

    dialogBuilder.setView(dialogView)

    if (negativeButtonText != null) {
        dialogBuilder.setNegativeButton(context.getString(negativeButtonText)) { _, _ ->
            negativeButtonAction?.invoke()
        }
    }

    if (positiveButtonText != null) {
        dialogBuilder.setPositiveButton(context.getString(positiveButtonText)) { _, _ ->
            positiveButtonAction?.invoke()
        }
    }
    dialogBuilder.setCancelable(isCancelable)

    return dialogBuilder.show()
}

