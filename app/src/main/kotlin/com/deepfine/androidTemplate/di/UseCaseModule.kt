package com.deepfine.androidTemplate.di

import com.deepfine.domain.repository.FactRepository
import com.deepfine.domain.usecase.GetFactsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
  @Singleton
  @Provides
  fun provideGetSampleUseCase(repository: FactRepository) = GetFactsUseCase(repository)
}
