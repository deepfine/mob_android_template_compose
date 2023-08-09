package com.deepfine.data.repository

import com.deepfine.data.utils.asResult
import com.deepfine.data.utils.withIOContext
import com.deepfine.domain.model.Sample
import com.deepfine.domain.repository.SampleRepository
import com.deepfine.network.datasource.SampleDataSource
import com.deepfine.network.entity.SampleEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
class SampleRepositoryImpl @Inject constructor(
  private val dataSource: SampleDataSource
) : SampleRepository {
  override suspend fun getFacts(): Flow<Result<Sample>> =
    dataSource.getSample()
      .map(SampleEntity::toDomain)
      .asResult()
      .withIOContext()
}