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
  setLibraryConfig()

  flavorDimensions.add("api")
  productFlavors {
    create("dev")
    create("production")
  }
}

dependencies {
  implementation(libs.kotlin.coroutine.core)
  implementation(libs.hilt)
  implementation(libs.ktor.serialization.kotlinx.json)
  implementation(libs.ktor.serialization)

  kapt(libs.hilt.compiler.get())
}
