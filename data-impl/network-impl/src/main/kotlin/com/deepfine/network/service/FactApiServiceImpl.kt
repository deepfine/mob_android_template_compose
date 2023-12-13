package com.deepfine.network.service

import com.deepfine.network.model.FactsApiModel
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.ktor.getApiResponse
import io.ktor.client.HttpClient
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
class FactApiServiceImpl @Inject constructor(
  private val client: HttpClient
) : FactApiService {
  override suspend fun getFacts(): ApiResponse<FactsApiModel> =
    client.getApiResponse(urlString = "/facts")
}
