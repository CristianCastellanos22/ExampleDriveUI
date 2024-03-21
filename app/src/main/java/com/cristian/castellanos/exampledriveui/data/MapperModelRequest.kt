package com.cristian.castellanos.exampledriveui.data

import com.cristian.castellanos.exampledriveui.domain.model.ComponentUI
import com.cristian.castellanos.exampledriveui.domain.model.DataUI
import com.cristian.castellanos.exampledriveui.domain.model.MetaUI
import com.cristian.castellanos.exampledriveui.domain.model.PageUI
import com.cristian.castellanos.exampledriveui.data.model.Component
import com.cristian.castellanos.exampledriveui.data.model.Data
import com.cristian.castellanos.exampledriveui.data.model.Meta
import com.cristian.castellanos.exampledriveui.data.model.Page

fun Page.toPageUI(): PageUI {
    return PageUI(
        type = type,
        data = data.toDataUI()
    )
}

fun Data.toDataUI(): DataUI {
    return DataUI(
        header = header,
        body = body.map { it.mapToComponentUI() },
        footer = footer
    )
}

fun Meta.toMetaUI(): MetaUI {
    return MetaUI(
        text = text,
        textSize = textSize,
        weightFont = weightFont,
        textAlignment = textAlignment,
        textColor = textColor
    )
}
