package com.deepfine.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * @Description BaseViewModel
 * @author yc.park (DEEP.FINE)
 * @since 2021-09-30
 * @version 1.0.0
 */
interface BaseViewModel

abstract class BaseViewModelImpl : ViewModel(), BaseViewModel {
  protected fun <T> FlowCollector<T>.emitOn(value: T) {
    viewModelScope.launch {
      this@emitOn.emit(value)
    }
  }

  protected suspend inline fun <R, T> Flow<Result<T>>.collectResult(crossinline onSuccess: suspend (T) -> R, crossinline onFailure: suspend (Throwable) -> R) = collectLatest { result ->
    result.fold(
      onSuccess = {
        onSuccess.invoke(it)
      },
      onFailure = {
        onFailure.invoke(it)
      }
    )
  }
}

class EmptyViewModel : BaseViewModel