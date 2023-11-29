package com.deepfine.network.util

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.getOrThrow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */

fun <T> T.asFlow(): Flow<T> = flow {
  emit(this@asFlow)
}

fun <T> ApiResponse<T>.responseToFlow(): Flow<T> =
  flow {
    emit(getOrThrow())
  }
