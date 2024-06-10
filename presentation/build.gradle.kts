plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.hilt)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.ksp)
  alias(libs.plugins.compose.compiler)
}

android {
  namespace = "com.deepfine.presentation"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.minSdk.get().toInt()
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  composeCompiler {
    enableStrongSkippingMode = true
    includeSourceInformation = true
  }
}

dependencies {
  implementation(project(":navigator"))
  implementation(project(":data-api"))
  runtimeOnly(project(":data-impl"))

  implementation(libs.kotlin.coroutine.core)
  implementation(libs.androidx.core.ktx)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.bundles.orbit)
  implementation(libs.bundles.compose)

  implementation(libs.hilt)
  ksp(libs.hilt.compiler)
}