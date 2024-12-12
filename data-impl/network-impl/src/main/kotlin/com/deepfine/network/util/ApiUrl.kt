package com.deepfine.network.util

import com.deepfine.buildconfig.BuildConfig
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol

internal object ApiUrl {
  val builder: URLBuilder.() -> Unit = {
    this.protocol = ApiUrl.protocol
    this.host = ApiUrl.host
  }

  private val protocol: URLProtocol
    get() = when {
      BuildConfig.API_URL.startsWith("https://") -> URLProtocol.HTTPS
      BuildConfig.API_URL.startsWith("http://") -> URLProtocol.HTTP
      else -> throw RuntimeException("Not supported API url")
    }

  private val host
    get() = when (protocol) {
      URLProtocol.HTTP -> BuildConfig.API_URL.split("http://").last()
      URLProtocol.HTTPS -> BuildConfig.API_URL.split("https://").last()
      else -> throw RuntimeException("Not supported API url")
    }
}
