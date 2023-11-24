package com.deepfine.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@Serializable
@Parcelize
data class Fact(
  val fact: String,
  val length: Int
) : Parcelable
