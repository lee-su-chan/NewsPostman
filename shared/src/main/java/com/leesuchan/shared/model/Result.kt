package com.leesuchan.shared.model

sealed class Result<out R> {

    object Loading : Result<Nothing>()

    data class Success<out T>(val data: T) : Result<T>()

    data class Failure(val exception: Throwable) : Result<Nothing>()

    override fun toString(): String = when (this) {
        is Loading -> "Loading"
        is Success<*> -> "Success[data=$data]"
        is Failure -> "Failure[exception=$exception]"
    }
}

val Result<*>.isSuccess get() = this is Result.Success && data != null

val Result<*>.isFailure get() = !isSuccess

fun <T> Result<T>.getOrNull(): T? = (this as? Result.Success<T>)?.data

fun <T> Result<T>.getOrDefault(default: T): T = (this as? Result.Success<T>)?.data ?: default

fun <T> Result<T>.getOrThrow(): T {
    throwOnFailure()
    return (this as Result.Success<T>).data
}

fun Result<*>.throwOnFailure() {
    if (this is Result.Failure) throw exception
}

fun Result<*>.getExceptionOrNull(): Throwable? = (this as? Result.Failure)?.exception

fun <T> Result<T>.handle(
    loadingBlock: (() -> Unit)? = null,
    successBlock: ((T) -> Unit)? = null,
    failureBlock: ((Throwable) -> Unit)? = null,
    finallyBlock: (() -> Unit)? = null
) {
    when (this) {
        is Result.Loading -> loadingBlock?.invoke()
        is Result.Success -> successBlock?.invoke(data)
        is Result.Failure -> failureBlock?.invoke(exception)
    }
    finallyBlock?.invoke()
}
