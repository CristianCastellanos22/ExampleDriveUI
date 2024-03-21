package com.cristian.castellanos.exampledriveui.presentation.components

import com.cristian.castellanos.exampledriveui.domain.model.ComponentUI

interface CustomView<T: ComponentUI> {
    fun loadComponent(component: T)
}