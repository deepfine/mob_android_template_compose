package com.deepfine.network.di

import com.deepfine.network.util.NetworkLogger
import com.deepfine.network.util.NetworkLoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractNetworkModule {
  @Binds
  abstract fun bindNetworkLogger(
    networkLoggerImpl: NetworkLoggerImpl
  ): NetworkLogger
}
