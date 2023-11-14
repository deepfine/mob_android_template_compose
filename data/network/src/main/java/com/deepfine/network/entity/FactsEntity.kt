package com.deepfine.network.entity

import com.deepfine.domain.model.Fact
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Serializable
data class FactsEntity(
  @SerialName("data")
  val facts: List<FactEntity>,
) {
  fun toDomain() =
    facts.map(FactEntity::toDomain)
}

@Serializable
data class FactEntity(
  @SerialName("fact")
  val fact: String,

  @SerialName("length")
  val length: Int,
) {
  fun toDomain() = Fact(fact, length)
}
