plugins {
  alias(libs.plugins.deepfine.presentation)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.deepfine.scheme"

  kotlin {
    compilerOptions.freeCompilerArgs.add(
      "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
    )
  }
}

dependencies {
  implementation(project(":presentation"))
  implementation(project(":presentation:main"))

  implementation(libs.splashScreen)
  implementation(libs.kotlin.serialization)
  implementation(libs.bottomsheet.navigator)
}
