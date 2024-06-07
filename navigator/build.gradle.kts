plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
  kotlin("android")
  id(libs.plugins.compose.compiler.get().pluginId)
}

android {
  namespace = "com.deepfine.navigator"

  compileSdk = libs.versions.compileSdk.get().toInt()

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  buildFeatures.compose = true
}

dependencies {
  implementation(project(":data-api"))
  implementation(libs.androidx.compose.navigation)
  implementation(libs.kotlin.serialization)
}
