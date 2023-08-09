package com.deepfine.domain.di

import com.deepfine.domain.repository.SampleRepository
import com.deepfine.domain.usecase.GetSampleUseCase
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
  fun provideGetSampleUseCase(repository: SampleRepository) = GetSampleUseCase(repository)
}