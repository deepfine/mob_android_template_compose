package com.deepfine.home.model

import com.deepfine.domain.model.Fact

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
data class MainState(
  val loading: Boolean = false,
  val facts: List<Fact> = listOf(),
  val error: Throwable? = null
)