package com.deepfine.splash.model

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
internal sealed interface SplashSideEffect {
  data object NavigateToMain : SplashSideEffect
}
