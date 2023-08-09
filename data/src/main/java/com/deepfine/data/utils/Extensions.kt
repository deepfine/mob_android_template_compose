package com.deepfine.data.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-09
 * @version 1.0.0
 */

internal inline fun <reified T> T.asFlow() = flow {
  emit(this@asFlow)
}

internal inline fun <reified T, R> Flow<List<T>>.mapNested(crossinline transform: (T) -> R) = map { entities ->
  entities.map(transform)
}

internal fun <T> Flow<T>.asResult(): Flow<Result<T>> = map { data ->
  Result.success(data)
}.catch { throwable ->
  emit(Result.failure(throwable))
}

fun <T> Flow<T>.withIOContext() = this.flowOn(Dispatchers.IO)
