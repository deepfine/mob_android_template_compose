package com.deepfine.network.di

import com.deepfine.network.service.FactApiService
import com.deepfine.network.service.FactApiServiceImpl
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
  abstract fun bindFactApiService(
    factApiServiceImpl: FactApiServiceImpl
  ): FactApiService
}
