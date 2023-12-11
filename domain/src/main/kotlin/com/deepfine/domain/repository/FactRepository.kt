package com.deepfine.domain.repository

import com.deepfine.domain.model.Fact
import kotlinx.coroutines.flow.Flow

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
interface FactRepository {
  suspend fun getFacts(): Flow<Result<List<Fact>>>
}
