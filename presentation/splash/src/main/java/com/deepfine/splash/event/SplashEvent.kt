package com.deepfine.splash.event

import com.deepfine.domain.model.Sample

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
sealed interface SplashEvent {
  data object Loading : SplashEvent
  data class Loaded(val sample: Sample) : SplashEvent
  data class Error(val throwable: Throwable) : SplashEvent
}