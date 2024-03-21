package com.cristian.castellanos.exampledriveui.domain.model

import android.content.Context
import android.view.View
import com.cristian.castellanos.exampledriveui.data.model.TypeComponent
import com.cristian.castellanos.exampledriveui.presentation.components.LabelView

data class PageUI(
    val type: String,
    val data: DataUI
)

data class DataUI(
    val header: List<Any>,
    val body: List<ComponentUI>,
    val footer: List<Any>
)

data class LabelUI(
    override val type: TypeComponent,
    val id: String,
    val required: Boolean,
    val label: MetaUI
) : ComponentUI {
    override fun mapToView(context: Context): View? {
        val view = LabelView(context)
        view.loadComponent(this)
        return view
    }
}

data class TextFieldUI(
    override val type: TypeComponent,
    val id: String,
    val required: Boolean,
    val isEnable: Boolean,
    val textField: TextFieldMetaUI,
    val minLenght: Int,
    val maxLenght: Int,
    val keyboardType: String,
    val regex: String,
    val regexInline: String
) : ComponentUI {
    override fun mapToView(context: Context): View? {
        return null
    }
}

data class TextFieldMetaUI(
    val meta: MetaUI,
    val placeHolder: MetaUI?
)

interface ComponentUI {
    val type: TypeComponent

    fun mapToView(context: Context): View?
}

data class MetaUI(
    val text: String,
    val textSize: Int,
    val weightFont: String,
    val textAlignment: String?,
    val textColor: String
)