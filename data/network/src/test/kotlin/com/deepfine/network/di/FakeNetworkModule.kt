package com.deepfine.network.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */

object FakeNetworkModule {
  fun provideKtorSuccessClient() = provideKtorClient(FakeEngine.getSuccess())
  fun provideKtorFailureClient() = provideKtorClient(FakeEngine.getFailure())

  private fun provideKtorClient(engine: HttpClientEngine) = HttpClient(engine) {
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

object FakeEngine {
  fun getSuccess() = successClient.engine
  fun getFailure() = failureClient.engine

  private val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))

  private val successClient = HttpClient(MockEngine) {
    engine {
      addHandler { request ->
        respond(FakeRespond.fromEncodedPath(request.url.encodedPath), HttpStatusCode.OK, responseHeaders)
      }
    }
  }

  private val failureClient = HttpClient(MockEngine) {
    engine {
      addHandler { request ->
        respond(FakeRespond.fromEncodedPath(request.url.encodedPath), HttpStatusCode.BadRequest, responseHeaders)
      }
    }
  }
}
