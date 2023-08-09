package com.deepfine.splash.viewModel

import androidx.lifecycle.viewModelScope
import com.deepfine.domain.model.Sample
import com.deepfine.domain.usecase.GetSampleUseCase
import com.deepfine.presentation.base.BaseViewModelImpl
import com.deepfine.presentation.utils.EventFlow
import com.deepfine.presentation.utils.MutableEventFlow
import com.deepfine.presentation.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
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

  private val _sample = MutableEventFlow<Sample>()
  val sample: EventFlow<Sample>
    get() = _sample.asEventFlow()

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

  private suspend fun onFetchSampleSuccess(sample: Sample) {
    _sample.emit(sample)
  }

  private fun onFetchSampleFailure(throwable: Throwable) {
    // TODO : Do something with throwable
  }
}