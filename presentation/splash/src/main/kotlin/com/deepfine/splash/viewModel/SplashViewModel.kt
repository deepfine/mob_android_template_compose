package com.deepfine.splash.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepfine.splash.model.SplashSideEffect
import com.deepfine.splash.model.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-09
 * @version 1.0.0
 */
@HiltViewModel
internal class SplashViewModel @Inject constructor() : ViewModel(), ContainerHost<SplashState, SplashSideEffect> {
  override val container: Container<SplashState, SplashSideEffect> = container(SplashState())

  init {
    countSplashTime()
  }

  private fun countSplashTime() = intent {
    viewModelScope.launch {
      delay(SPLASH_MILLIS)
      postSideEffect(SplashSideEffect.NavigateToMain)
    }
  }

  companion object {
    private const val SPLASH_MILLIS = 2000L
  }
}
