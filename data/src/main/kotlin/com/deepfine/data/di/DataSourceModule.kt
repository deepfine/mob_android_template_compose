package com.deepfine.data.di

import com.deepfine.network.datasource.NetworkDataSource
import com.deepfine.network.datasource.NetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-09
 * @version 1.0.0
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
  @Binds
  abstract fun bindSampleDataSource(
    sampleDataSourceImpl: NetworkDataSourceImpl
  ): NetworkDataSource
}
