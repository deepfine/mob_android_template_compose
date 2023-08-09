package com.deepfine.network.di

import com.deepfine.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.http.URLProtocol
import javax.inject.Singleton

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
  @Singleton
  @Provides
  fun provideKtorClient() = HttpClient(Android) {
    defaultRequest {
      url {
        protocol = URLProtocol.HTTPS
        host = BuildConfig.API_URL
        host = "catfact.ninja"
      }
    }

    install(Logging) {
      logger = Logger.DEFAULT
      level = LogLevel.ALL
    }

    install(JsonFeature) {
      serializer = KotlinxSerializer()
    }
  }
}