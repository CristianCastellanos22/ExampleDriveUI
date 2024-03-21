package com.cristian.castellanos.exampledriveui.data.model

import com.cristian.castellanos.exampledriveui.domain.model.ComponentUI
import com.cristian.castellanos.exampledriveui.domain.model.LabelUI
import com.cristian.castellanos.exampledriveui.domain.model.MetaUI
import com.cristian.castellanos.exampledriveui.domain.model.TextFieldMetaUI
import com.cristian.castellanos.exampledriveui.domain.model.TextFieldUI

data class Page(
    val type: String,
    val data: Data,
)

data class Data(
    val header: List<Any>,
    val body: List<Component>,
    val footer: List<Any>,
)

data class Label(
    val id: String,
    val required: Boolean,
    val label: LabelMeta,
) : Component {
    override val type: TypeComponent = TypeComponent.LABEL
    override fun mapToComponentUI(): ComponentUI {
        return LabelUI(
            type = type,
            id = id,
            required = required,
            label = label.meta.toMetaUI()
        )
    }
}

data class TextField(
    val id: String,
    val required: Boolean,
    val isEnable: Boolean,
    val textField: LabelMeta,
    val minLenght: Int,
    val maxLenght: Int,
    val keyboardType: String,
    val regex: String,
    val regexInline: String,
) : Component {
    override val type: TypeComponent = TypeComponent.TEXT_FIELD
    override fun mapToComponentUI(): ComponentUI {
        return TextFieldUI(
            type = type,
            id = id,
            required = required,
            isEnable = isEnable,
            textField = textField.toTextFieldMetaUI(),
            minLenght = minLenght,
            maxLenght = maxLenght,
            keyboardType = keyboardType,
            regex = regex,
            regexInline = regexInline
        )
    }

}

data class LabelMeta(
    val meta: Meta,
    val placeHolder: PlaceHolder?,
) {
    fun toTextFieldMetaUI(): TextFieldMetaUI {
        return TextFieldMetaUI(
            meta = meta.toMetaUI(),
            placeHolder = placeHolder?.meta?.toMetaUI()
        )
    }
}

data class Meta(
    val text: String,
    val textSize: Int,
    val weightFont: String,
    val textAlignment: String?,
    val textColor: String,
) {
    fun toMetaUI(): MetaUI {
        return MetaUI(
            text = this.text,
            textSize = this.textSize,
            weightFont = this.weightFont,
            textAlignment = this.textAlignment,
            textColor = this.textColor,
        )
    }
}

data class PlaceHolder(
    val meta: Meta,
)

interface Component {
    val type: TypeComponent

    fun mapToComponentUI(): ComponentUI
}

enum class TypeComponent {
     LABEL,
    TEXT_FIELD,
}