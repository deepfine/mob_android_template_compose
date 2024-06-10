import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.hilt)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.ksp)
  alias(libs.plugins.compose.compiler)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.deepfine.scheme"
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.minSdk.get().toInt()
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  kotlin {
    compilerOptions.freeCompilerArgs.add(
      "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
    )
  }

  composeCompiler {
    enableStrongSkippingMode = true
    includeSourceInformation = true
  }
}

dependencies {
  implementation(project(":presentation"))
  implementation(project(":presentation:main"))
  implementation(project(":navigator"))
  implementation(project(":data-api"))
  runtimeOnly(project(":data-impl"))

  implementation(libs.kotlin.coroutine.core)
  implementation(libs.androidx.core.ktx)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.bundles.orbit)
  implementation(libs.bundles.compose)
  implementation(libs.splashScreen)
  implementation(libs.kotlin.serialization)
  implementation(libs.bottomsheet.navigator)

  implementation(libs.hilt)
  ksp(libs.hilt.compiler)
}