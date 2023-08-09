package com.deepfine.network.datasource

import com.deepfine.network.entity.SampleEntity
import com.deepfine.network.service.SampleApiService
import com.deepfine.network.util.asFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
interface SampleDataSource {
  suspend fun getSample(): Flow<SampleEntity>
}

class SampleDataSourceImpl @Inject constructor(
  private val service: SampleApiService
) : SampleDataSource {
  override suspend fun getSample(): Flow<SampleEntity> =
    service.execute().asFlow()
}