@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
  namespace = "com.deepfine.fact"

  compileSdk = AppConfiguration.COMPILE_SDK

  compileOptions {
    sourceCompatibility = AppConfiguration.JAVA_VERSION
    targetCompatibility = AppConfiguration.JAVA_VERSION
  }

  buildFeatures.compose = true
  composeOptions.kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
}

dependencies {
  implementation(project(":domain"))
  implementation(project(":presentation"))
  implementation(libs.bundles.presentation)
  implementation(libs.hilt)
  implementation(libs.bundles.orbit)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.bundles.compose)

  kapt(libs.hilt.compiler.get())
}
