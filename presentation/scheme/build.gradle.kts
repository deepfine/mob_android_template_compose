plugins {
  alias(libs.plugins.deepfine.presentation)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.deepfine.scheme"
}

dependencies {
  implementation(projects.presentation)
  implementation(projects.presentation.main)

  implementation(libs.splashScreen)
  implementation(libs.kotlin.serialization)
  implementation(libs.bottomsheet.navigator)
}
