package com.deepfine.network.util

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import io.ktor.client.plugins.logging.Logger
import java.io.File
import java.io.PrintWriter
import javax.inject.Inject

interface NetworkLogger : Logger {
  companion object {
    const val LOG_FILE_NAME = "network.log"
  }
}

class NetworkLoggerImpl @Inject constructor(
  @ApplicationContext private val context: Context
) : NetworkLogger {
  private val file: File by lazy {
    File(context.getExternalFilesDir("log"), NetworkLogger.LOG_FILE_NAME)
  }

  override fun log(message: String) {
    try {
      file.outputStream().use { fos ->
        PrintWriter(fos).use { writer ->
          writer.appendLine(message)
          writer.appendLine("======================================================================================================")
        }
      }
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }
}
