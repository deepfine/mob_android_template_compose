package com.deepfine.domain.model

import kotlinx.serialization.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@Serializable
data class Fact(
  val fact: String,
  val length: Int
) : java.io.Serializable {
  override fun toString(): String = "$length. $fact"
}
