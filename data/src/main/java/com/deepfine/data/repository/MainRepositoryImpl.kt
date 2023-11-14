package com.deepfine.data.repository

import com.deepfine.data.utils.asResult
import com.deepfine.data.utils.withIOContext
import com.deepfine.domain.model.Fact
import com.deepfine.domain.repository.MainRepository
import com.deepfine.network.datasource.NetworkDataSource
import com.deepfine.network.entity.FactsEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
class MainRepositoryImpl @Inject constructor(
  private val dataSource: NetworkDataSource,
) : MainRepository {
  override suspend fun getFacts(): Flow<Result<List<Fact>>> =
    dataSource.getFacts()
      .map(FactsEntity::toDomain)
      .asResult()
      .withIOContext()
}
