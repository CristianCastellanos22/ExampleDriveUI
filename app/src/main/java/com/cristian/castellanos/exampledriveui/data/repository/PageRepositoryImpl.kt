package com.cristian.castellanos.exampledriveui.data.repository

import com.cristian.castellanos.exampledriveui.data.toPageUI
import com.cristian.castellanos.exampledriveui.di.ApiService
import com.cristian.castellanos.exampledriveui.domain.model.PageUI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import com.cristian.castellanos.exampledriveui.data.network.resultOf

class PageRepositoryImpl(
    private val apiService: ApiService,
    private val dispatchers: CoroutineDispatcher,
) : PageRepository {

    override suspend fun getPage(id: String): Result<PageUI> = resultOf {
        val result = withContext(dispatchers) {
            //apiService.getPage(id)
            apiService.getPage()
        }
        val body = result.body()

        if (result.isSuccessful && body != null) {
            body.toPageUI()
        } else {
            val errorMessage = result.errorBody().toString()
            error(errorMessage)
        }

    }
}