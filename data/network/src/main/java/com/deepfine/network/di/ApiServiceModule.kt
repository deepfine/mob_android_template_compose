package com.deepfine.network.di

import com.deepfine.network.service.SampleApiService
import com.deepfine.network.service.SampleApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class ApiServiceModule {

  @Binds
  abstract fun bindSampleApiService(
    sampleApiServiceImpl: SampleApiServiceImpl
  ): SampleApiService
}