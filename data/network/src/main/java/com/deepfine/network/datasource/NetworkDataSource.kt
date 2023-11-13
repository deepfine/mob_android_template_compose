package com.deepfine.network.datasource

import com.deepfine.network.entity.FactsEntity
import com.deepfine.network.service.FactApiService
import com.deepfine.network.util.responseToFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
interface NetworkDataSource {
  suspend fun getFacts(): Flow<FactsEntity>
}

class NetworkDataSourceImpl @Inject constructor(
  private val service: FactApiService
) : NetworkDataSource {
  override suspend fun getFacts(): Flow<FactsEntity> =
    service.getFacts().responseToFlow()
}