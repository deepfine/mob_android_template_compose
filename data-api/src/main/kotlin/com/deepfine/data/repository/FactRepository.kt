package com.deepfine.data.repository

import com.deepfine.data.model.Fact
import kotlinx.coroutines.flow.Flow

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
interface FactRepository {
  suspend fun getFacts(): Flow<Result<List<Fact>>>
}
