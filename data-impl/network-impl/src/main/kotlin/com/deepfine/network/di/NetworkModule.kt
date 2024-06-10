package com.deepfine.network.di

import com.deepfine.buildconfig.BuildConfig
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
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
  @Singleton
  @Provides
  fun provideKtorClient() = HttpClient {
    install(DefaultRequest) {
      url {
        protocol = if (BuildConfig.API_URL.startsWith("https")) URLProtocol.HTTPS else URLProtocol.HTTP
        host = if (BuildConfig.API_URL.startsWith("https")) BuildConfig.API_URL.split("https://").last() else BuildConfig.API_URL.split("http://").last()
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

    install(DefaultRequest) {
      header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
  }
}
