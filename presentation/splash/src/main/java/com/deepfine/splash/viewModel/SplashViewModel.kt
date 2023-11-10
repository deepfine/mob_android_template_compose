package com.deepfine.splash.viewModel

import androidx.lifecycle.viewModelScope
import com.deepfine.domain.model.Sample
import com.deepfine.domain.usecase.GetSampleUseCase
import com.deepfine.presentation.base.BaseViewModelImpl
import com.deepfine.splash.event.SplashEvent
import com.deepfine.splash.sideEffect.SplashSideEffect
import com.deepfine.splash.state.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-09
 * @version 1.0.0
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
  private val getSampleUseCase: GetSampleUseCase
) : BaseViewModelImpl() {

  private val event = Channel<SplashEvent>()

  val state: StateFlow<SplashState> = event.receiveAsFlow()
    .runningFold(SplashState(), ::reduceState)
    .stateIn(viewModelScope, SharingStarted.Eagerly, SplashState())

  private val _sideEffects = Channel<SplashSideEffect>()
  val sideEffects = _sideEffects.receiveAsFlow()

  private fun reduceState(current: SplashState, event: SplashEvent): SplashState {
    return when (event) {
      SplashEvent.Loading -> current.copy(loading = true)
      is SplashEvent.Loaded -> current.copy(loading = false, sample = event.sample)
      is SplashEvent.Error -> current.copy(loading = false, error = event.throwable)
    }
  }

  init {
    requestSample()
  }

  private fun requestSample() {
    viewModelScope.launch {
      event.send(SplashEvent.Loading)
      getSampleUseCase().collectResult(
        ::onFetchSampleSuccess,
        ::onFetchSampleFailure
      )
    }
  }

  private suspend fun onFetchSampleSuccess(sample: Sample) {
    event.send(SplashEvent.Loaded(sample))
  }

  private suspend fun onFetchSampleFailure(throwable: Throwable) {
    event.send(SplashEvent.Error(throwable))
    _sideEffects.send(SplashSideEffect.Error(throwable))
  }
}