package com.deepfine.domain.usecase

import com.deepfine.domain.repository.SplashRepository
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
class GetFactsUseCase @Inject constructor(private val repository: SplashRepository) {
  suspend operator fun invoke() = repository.getFacts()
}