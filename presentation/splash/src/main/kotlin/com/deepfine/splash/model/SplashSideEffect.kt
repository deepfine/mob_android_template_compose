package com.deepfine.splash.model

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
sealed interface SplashSideEffect {
  data object NavigateToMain : SplashSideEffect
}
