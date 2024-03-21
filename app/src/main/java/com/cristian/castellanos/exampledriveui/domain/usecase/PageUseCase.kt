package com.cristian.castellanos.exampledriveui.domain.usecase

import com.cristian.castellanos.exampledriveui.domain.model.PageUI

interface PageUseCase {
    suspend fun getPage(id: String): Result<PageUI>
}