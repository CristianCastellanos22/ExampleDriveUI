package com.cristian.castellanos.exampledriveui.presentation.components.commons

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout

internal fun Context.createViewGroup(
    layoutWidth: Int = ViewGroup.LayoutParams.MATCH_PARENT,
    layoutHeight: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
    layoutOrientation: Int = LinearLayout.VERTICAL
): LinearLayout =
    LinearLayout(this).apply {
        layoutParams = ViewGroup.LayoutParams(layoutWidth, layoutHeight)
        orientation = layoutOrientation
    }