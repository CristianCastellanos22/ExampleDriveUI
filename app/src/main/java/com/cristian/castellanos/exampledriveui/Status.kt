package com.cristian.castellanos.exampledriveui

sealed class Status<out T> {
    data class Success<T>(val data: T): Status<T>()
    data object Loading: Status<Nothing>()
    data class Error<T>(val message: String): Status<T>()
}