package com.deepfine.data.repository

import com.deepfine.data.mapper.toModel
import com.deepfine.data.model.Fact
import com.deepfine.data.util.asResult
import com.deepfine.data.util.withIOContext
import com.deepfine.network.datasource.NetworkDataSource
import com.deepfine.network.model.FactsApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
class FactRepositoryImpl @Inject constructor(
  private val dataSource: NetworkDataSource
) : FactRepository {
  override suspend fun getFacts(): Flow<Result<List<Fact>>> =
    dataSource.getFacts()
      .map(FactsApiModel::toModel)
      .asResult()
      .withIOContext()
}
