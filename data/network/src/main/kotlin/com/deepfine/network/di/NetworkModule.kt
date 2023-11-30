package com.deepfine.network.di

import com.deepfine.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
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
  fun provideKtorClient() = HttpClient {
    install(DefaultRequest) {
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

    install(ContentNegotiation) {
      json(
        Json {
          prettyPrint = true
          ignoreUnknownKeys = true
          isLenient = true
          encodeDefaults = true
        },
      )
    }
  }
}
