package com.deepfine.home.model

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
sealed interface FactSideEffect {
  data class Error(val throwable: Throwable) : FactSideEffect
}
