package com.deepfine.splash.state

import com.deepfine.domain.model.Sample

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
sealed interface SplashState {
  data object Loading : SplashState
  data class SampleLoaded(val sample: Sample) : SplashState
  data object LoadFailure : SplashState
}