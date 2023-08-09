package com.deepfine.network.service

import com.deepfine.network.entity.SampleEntity
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
interface SampleApiService {
  suspend fun execute(): SampleEntity
}

class SampleApiServiceImpl @Inject constructor(
  private val client: HttpClient
) : SampleApiService {
  override suspend fun execute(): SampleEntity =
    try {
      client.get(path = "/fact")
    } catch (e: Exception) {
      SampleEntity("ERROR", -999)
    }
}