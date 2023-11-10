package com.deepfine.network.service

import com.deepfine.network.entity.FactsEntity
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
interface FactApiService {
  suspend fun execute(): FactsEntity
}

class FactApiServiceImpl @Inject constructor(
  private val client: HttpClient
) : FactApiService {
  override suspend fun execute(): FactsEntity =
    client.get(path = "/facts")
}