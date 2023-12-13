package com.deepfine.network.utils

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.getOrThrow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

fun <T> T.asFlow(): Flow<T> = flow {
  emit(this@asFlow)
}

fun <T> ApiResponse<T>.responseToFlow(): Flow<T> =
  flow {
    emit(getOrThrow())
  }
