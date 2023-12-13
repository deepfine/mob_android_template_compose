package com.deepfine.network.datasource

import com.deepfine.network.model.FactsApiModel
import com.deepfine.network.service.FactApiService
import com.deepfine.network.utils.responseToFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
class NetworkDataSourceImpl @Inject constructor(
  private val service: FactApiService
) : NetworkDataSource {
  override suspend fun getFacts(): Flow<FactsApiModel> =
    service.getFacts()
      .responseToFlow()
      .flowOn(Dispatchers.IO)
}
