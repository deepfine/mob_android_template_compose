plugins {
  alias(libs.plugins.deepfine.presentation)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.deepfine.main"
}

dependencies {
  implementation(projects.presentation)

  implementation(libs.kotlin.serialization)
}
