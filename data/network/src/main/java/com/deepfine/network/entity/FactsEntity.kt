package com.deepfine.network.entity

import com.deepfine.domain.model.Fact
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Serializable
data class FactsEntity(
  @SerializedName("data")
  val facts: List<FactEntity>
) {
  fun toDomain() =
    facts.map(FactEntity::toDomain)
}

@Serializable
data class FactEntity(
  @SerializedName("fact")
  val fact: String,

  @SerializedName("length")
  val length: Int
) {
  fun toDomain() = Fact(fact, length)
}
