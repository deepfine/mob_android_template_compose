package com.deepfine.network.di

import io.ktor.client.HttpClient
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
  fun provideKtorClient() = HttpClient(FakeEngine.get()) {
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
  fun get() = client.engine

  private val responseHeaders = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))

  private val client = HttpClient(MockEngine) {
    engine {
      addHandler { request ->
        respond(FakeRespond.fromEncodedPath(request.url.encodedPath), HttpStatusCode.OK, responseHeaders)
      }
    }
  }
}
