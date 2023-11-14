package com.deepfine.domain.model

import java.io.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

data class Fact(
  val fact: String,
  val length: Int,
) : Serializable
