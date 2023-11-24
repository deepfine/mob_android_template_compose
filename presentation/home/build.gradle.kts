@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}

android {
  namespace = "com.deepfine.home"
  setLibraryConfig()
  setComposeEnabled()

  flavorDimensions.add("api")
  productFlavors {
    create("dev")
    create("production")
  }
}

dependencies {
  implementation(project(":domain"))
  implementation(project(":presentation"))
  implementation(libs.bundles.presentation)
  implementation(libs.bundles.orbit)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.bundles.compose)
  implementation(libs.ktor.serialization.kotlinx.json)
  implementation(libs.ktor.serialization)

  kapt(libs.hilt.compiler.get())
}
