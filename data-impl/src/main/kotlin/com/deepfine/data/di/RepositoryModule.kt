package com.deepfine.data.di

import com.deepfine.data.repository.FactRepository
import com.deepfine.data.repository.FactRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

  @Binds
  abstract fun bindFactRepository(
    factRepositoryImpl: FactRepositoryImpl
  ): FactRepository
}
