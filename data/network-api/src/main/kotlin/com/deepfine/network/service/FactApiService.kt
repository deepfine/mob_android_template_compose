package com.deepfine.network.service

import com.deepfine.network.model.FactsApiModel
import com.skydoves.sandwich.ApiResponse

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
interface FactApiService {
  suspend fun getFacts(): ApiResponse<FactsApiModel>
}
