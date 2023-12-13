package com.deepfine.network.di

import com.deepfine.network.datasource.NetworkDataSource
import com.deepfine.network.datasource.NetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
  @Binds
  abstract fun bindNetworkDataSource(
    networkDataSourceImpl: NetworkDataSourceImpl
  ): NetworkDataSource
}
