@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
  namespace = "com.deepfine.main"
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

  kapt(libs.hilt.compiler.get())
}
