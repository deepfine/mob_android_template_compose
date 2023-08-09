package com.deepfine.domain.usecase

import com.deepfine.domain.repository.SampleRepository
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
class GetSampleUseCase @Inject constructor(private val repository: SampleRepository) {
  suspend operator fun invoke() = repository.getFacts()
}