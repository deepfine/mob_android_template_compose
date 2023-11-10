package com.deepfine.splash.sideEffect

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
sealed interface SplashSideEffect {
  data class Error(val throwable: Throwable) : SplashSideEffect
}