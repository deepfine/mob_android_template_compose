package com.deepfine.splash.model

import com.deepfine.domain.model.Fact

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
data class SplashState(
  val loading: Boolean = false,
  val facts: List<Fact> = listOf(),
  val error: Throwable? = null
)