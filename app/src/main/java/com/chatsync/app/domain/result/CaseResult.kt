package com.chatsync.app.domain.result

sealed class CaseResult<T> {
    data class Success<T>(val result: T) : CaseResult<T>()
    data class Failure<T>(val throwable: Throwable) : CaseResult<T>()
}