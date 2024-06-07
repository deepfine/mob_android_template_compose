plugins {
  id(libs.plugins.deepfine.presentation.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}

android {
  namespace = "com.deepfine.scheme"

  kotlin {
    compilerOptions.freeCompilerArgs.addAll(
      "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
    )
  }
}

dependencies {
  implementation(project(":presentation"))
  implementation(project(":presentation:fact"))

  implementation(libs.splashScreen)
  implementation(libs.kotlin.serialization)
  implementation(libs.bottomsheet.navigator)
}
