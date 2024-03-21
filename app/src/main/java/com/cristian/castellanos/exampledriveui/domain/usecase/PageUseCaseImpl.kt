package com.cristian.castellanos.exampledriveui.domain.usecase

import com.cristian.castellanos.exampledriveui.data.repository.PageRepository
import com.cristian.castellanos.exampledriveui.domain.model.PageUI

class PageUseCaseImpl(
    private val pageRepository: PageRepository
) : PageUseCase {
    override suspend fun getPage(id: String): Result<PageUI> {
        return pageRepository.getPage(id)
    }
}