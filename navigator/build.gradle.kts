plugins {
  alias(libs.plugins.deepfine.android)
  alias(libs.plugins.deepfine.compose)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.deepfine.navigator"
}

dependencies {
  implementation(projects.dataApi)

  implementation(libs.androidx.compose.navigation)
  implementation(libs.kotlin.serialization)
}
