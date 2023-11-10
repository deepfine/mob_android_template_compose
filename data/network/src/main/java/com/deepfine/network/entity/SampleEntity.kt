package com.deepfine.network.entity

import com.deepfine.domain.model.Sample
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
@Serializable
data class SampleEntity(
  @SerializedName("fact")
  val fact: String,

  @SerializedName("length")
  val length: Int
) {
  fun toDomain() =
    if (length != -999)
      Sample(fact, length)
    else {
      throw RuntimeException()
    }
}
