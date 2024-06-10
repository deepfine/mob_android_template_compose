package com.deepfine.network.di

import com.deepfine.network.service.ApiService
import com.deepfine.network.service.ApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiServiceModule {
  @Binds
  abstract fun bindApiService(
    apiServiceImpl: ApiServiceImpl
  ): ApiService
}
