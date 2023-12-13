package com.deepfine.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Fact(
  val fact: String,
  val length: Int
) : java.io.Serializable {
  override fun toString(): String = "$length. $fact"
}
