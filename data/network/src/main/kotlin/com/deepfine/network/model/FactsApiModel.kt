package com.deepfine.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Serializable
data class FactsApiModel(
  @SerialName("data")
  val facts: List<FactApiModel>
)

@Serializable
data class FactApiModel(
  @SerialName("fact")
  val fact: String,

  @SerialName("length")
  val length: Int
)
