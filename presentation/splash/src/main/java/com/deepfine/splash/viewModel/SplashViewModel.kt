package com.deepfine.splash.viewModel

import androidx.lifecycle.viewModelScope
import com.deepfine.domain.model.Sample
import com.deepfine.domain.usecase.GetSampleUseCase
import com.deepfine.presentation.base.BaseViewModelImpl
import com.deepfine.splash.model.SplashSideEffect
import com.deepfine.splash.model.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-09
 * @version 1.0.0
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
  private val getSample: GetSampleUseCase
) : BaseViewModelImpl(), ContainerHost<SplashState, SplashSideEffect> {

  override val container: Container<SplashState, SplashSideEffect> = container(SplashState())

  init {
    requestSample()
  }

  private fun requestSample() = intent {
    viewModelScope.launch {
      reduce { state.copy(loading = true, error = null) }
      getSample().collectResult(
        ::onFetchSampleSuccess,
        ::onFetchSampleFailure
      )
    }
  }

  private suspend fun onFetchSampleSuccess(sample: Sample) = intent {
    reduce { state.copy(loading = false, sample = sample) }
  }

  private suspend fun onFetchSampleFailure(throwable: Throwable) = intent {
    reduce { state.copy(loading = false, error = throwable) }
    postSideEffect(SplashSideEffect.Error(throwable))
  }
}