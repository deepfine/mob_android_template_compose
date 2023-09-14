package com.deepfine.splash.viewModel

import androidx.lifecycle.viewModelScope
import com.deepfine.domain.model.Sample
import com.deepfine.domain.usecase.GetSampleUseCase
import com.deepfine.presentation.base.BaseViewModelImpl
import com.deepfine.presentation.utils.EventFlow
import com.deepfine.presentation.utils.MutableEventFlow
import com.deepfine.presentation.utils.asEventFlow
import com.deepfine.splash.state.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
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

  private val _uiState = MutableStateFlow<SplashState>(SplashState.Loading)
  val uiState: StateFlow<SplashState>
    get() = _uiState.asStateFlow()

  init {
    requestSample()
  }

  private fun requestSample() {
    viewModelScope.launch {
      getSampleUseCase().collectResult(
        ::onFetchSampleSuccess,
        ::onFetchSampleFailure
      )
    }
  }

  private fun onFetchSampleSuccess(sample: Sample) {
    _uiState.value = SplashState.SampleLoaded(sample)
  }

  private fun onFetchSampleFailure(throwable: Throwable) {
    _uiState.value = SplashState.LoadFailure
  }
}