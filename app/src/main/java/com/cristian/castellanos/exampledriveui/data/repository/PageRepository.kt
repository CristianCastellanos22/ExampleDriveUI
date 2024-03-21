package com.cristian.castellanos.exampledriveui.data.repository

import com.cristian.castellanos.exampledriveui.domain.model.PageUI

interface PageRepository {
    suspend fun getPage(id: String): Result<PageUI>
}