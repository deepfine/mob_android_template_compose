package com.deepfine.home.model

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
sealed interface MainSideEffect {
  data class Error(val throwable: Throwable) : MainSideEffect
}