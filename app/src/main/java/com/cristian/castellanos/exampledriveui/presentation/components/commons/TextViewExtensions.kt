package com.cristian.castellanos.exampledriveui.presentation.components.commons

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.graphics.toColorInt
import com.cristian.castellanos.exampledriveui.domain.model.MetaUI

fun MetaUI.createTextView(container: ViewGroup): TextView {
    return TextView(container.context).also { textView ->
        textView.text = text
        textView.textSize = textSize.toFloat()
        textView.gravity = TextAlignment.valueOf(textAlignment?.uppercase().orEmpty()).gravity
        textView.setTextColor(textColor.toColorStateList())
        container.addView(textView)
    }

}

enum class TextAlignment(val value: String, val gravity: Int) {
    LEFT("left", Gravity.START),
    RIGHT("right", Gravity.END),
    CENTER("center", Gravity.CENTER)
}

private fun String.toColorStateList(): ColorStateList {
    return ColorStateList.valueOf(this.toColor())
}

internal fun String.isValidColor(): Boolean = runCatching {
    toColorInt()
}.fold(
    onSuccess = {
        true
    },
    onFailure = {
        false
    }
)

internal fun String?.toColor(): Int =
    if (this?.isValidColor() == true) {
        this.toColorInt()
    } else {
        Color.BLACK
    }