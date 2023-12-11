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
  namespace = "com.deepfine.scheme"

  compileSdk = AppConfiguration.COMPILE_SDK

  compileOptions {
    sourceCompatibility = AppConfiguration.JAVA_VERSION
    targetCompatibility = AppConfiguration.JAVA_VERSION
  }

  buildFeatures.compose = true
  composeOptions.kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()

  hilt {
    enableAggregatingTask = true
  }
}

dependencies {
  implementation(project(":domain"))
  implementation(project(":presentation"))
  implementation(project(":presentation:fact"))

  implementation(libs.bundles.presentation)
  implementation(libs.bundles.orbit)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.bundles.compose)
  implementation(libs.splashScreen)
  implementation(libs.hilt)
  implementation(libs.kotlin.serialization)

  kapt(libs.hilt.compiler.get())
}
