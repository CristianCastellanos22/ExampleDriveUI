package com.cristian.castellanos.exampledriveui.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristian.castellanos.exampledriveui.Status
import com.cristian.castellanos.exampledriveui.domain.model.PageUI
import com.cristian.castellanos.exampledriveui.domain.usecase.PageUseCase
import kotlinx.coroutines.launch

class PageViewModel(private val getPagesUseCase: PageUseCase) : ViewModel() {

    private val _status = MutableLiveData<Status<PageUI>>()

    val status: LiveData<Status<PageUI>>
        get() = _status

    fun getPages() {
        _status.value = Status.Loading
        viewModelScope.launch {
            getPagesUseCase.getPage("")
                .onSuccess { pages ->
                    _status.value = Status.Success(pages)
                }
                .onFailure {
                    _status.value = Status.Error(it.message ?: "Error getting the pages")
                }
        }

    }

}
