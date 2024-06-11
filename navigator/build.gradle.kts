plugins {
  alias(libs.plugins.deepfine.android)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.compose.compiler)
}

android {
  namespace = "com.deepfine.navigator"
}

dependencies {
  implementation(project(":data-api"))
  implementation(libs.androidx.compose.navigation)
  implementation(libs.kotlin.serialization)
}
