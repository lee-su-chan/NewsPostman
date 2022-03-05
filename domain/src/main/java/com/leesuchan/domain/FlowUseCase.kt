package com.leesuchan.domain

import com.leesuchan.shared.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 * https://github.com/google/iosched/blob/main/shared/src/main/java/com/google/samples/apps/iosched/shared/domain/FlowUseCase.kt
 *
 * Executes business logic in its execute method and keep posting updates to the result as
 * [Result<R>].
 */
abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    operator fun invoke(param: P): Flow<Result<R>> = execute(param)
        .catch { e -> emit(Result.Failure(Exception(e))) }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: P): Flow<Result<R>>
}
