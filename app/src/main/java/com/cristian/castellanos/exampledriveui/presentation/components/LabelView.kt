package com.cristian.castellanos.exampledriveui.presentation.components

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import com.cristian.castellanos.exampledriveui.domain.model.LabelUI
import com.cristian.castellanos.exampledriveui.presentation.components.commons.createTextView

class LabelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : LinearLayout(context, attrs), CustomView<LabelUI> {

    init {
        orientation = VERTICAL
    }

    override fun loadComponent(component: LabelUI) {
        component.label.createTextView(this)
    }

}
