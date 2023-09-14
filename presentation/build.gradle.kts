@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
  namespace = "com.deepfine.presentation"
  setLibraryConfig()
  setViewBindingEnabled()

  flavorDimensions.add("api")
  productFlavors {
    create("dev")
    create("production")
  }
}

dependencies {
  implementation(project(":domain"))
  implementation(libs.bundles.presentation)
  implementation(libs.kotlin.coroutine.core)
  implementation(libs.androidx.ktx)
  kapt(libs.hilt.compiler.get())
}