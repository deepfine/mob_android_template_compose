package com.deepfine.splash.state

import com.deepfine.domain.model.Sample

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
data class SplashState(
  val loading: Boolean = false,
  val sample: Sample? = null,
  val error: Throwable? = null
)