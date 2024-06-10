plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.hilt)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.deepfine.network"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.minSdk.get().toInt()
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

dependencies {
  compileOnly(project(":buildconfig-stub"))
  implementation(project(":data-api:network-api"))

  implementation(libs.kotlin.coroutine.core)
  implementation(libs.kotlin.serialization)
  implementation(libs.bundles.ktor)
  implementation(libs.hilt)
  ksp(libs.hilt.compiler)
}