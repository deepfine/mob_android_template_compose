plugins {
  alias(libs.plugins.deepfine.android)
  alias(libs.plugins.deepfine.hilt)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.deepfine.data"
}

dependencies {
  implementation(project(":data-api"))

  implementation(project(":data-api:network-api"))
  runtimeOnly(project(":data-impl:network-impl"))
  implementation(libs.kotlin.serialization)
}
