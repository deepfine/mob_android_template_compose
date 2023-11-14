package com.deepfine.domain.usecase

import com.deepfine.domain.repository.MainRepository
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
class GetFactsUseCase @Inject constructor(private val repository: MainRepository) {
  suspend operator fun invoke() = repository.getFacts()
}
