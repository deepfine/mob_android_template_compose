package com.deepfine.network.datasource

import com.deepfine.network.model.FactsApiModel
import kotlinx.coroutines.flow.Flow

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
interface NetworkDataSource {
  suspend fun getFacts(): Flow<FactsApiModel>
}
