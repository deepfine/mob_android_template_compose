@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
  id(libs.plugins.kotlin.parcelize.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}

android {
  namespace = "com.deepfine.domain"

  compileSdk = AppConfiguration.COMPILE_SDK
  compileOptions {
    sourceCompatibility = AppConfiguration.JAVA_VERSION
    targetCompatibility = AppConfiguration.JAVA_VERSION
  }
}


dependencies {
  implementation(libs.kotlin.coroutine.core)
  implementation(libs.hilt)
  implementation(libs.kotlin.serialization)

  kapt(libs.hilt.compiler.get())
}
