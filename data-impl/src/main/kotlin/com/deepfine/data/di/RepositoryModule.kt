package com.deepfine.data.di

import com.deepfine.data.repository.MainRepository
import com.deepfine.data.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

  @Binds
  abstract fun bindMainRepository(
    mainRepositoryImpl: MainRepositoryImpl
  ): MainRepository
}
