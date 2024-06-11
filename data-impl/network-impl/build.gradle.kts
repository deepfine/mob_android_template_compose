plugins {
  alias(libs.plugins.deepfine.android)
  alias(libs.plugins.deepfine.hilt)
}

android {
  namespace = "com.deepfine.network"
}

dependencies {
  compileOnly(project(":buildconfig-stub"))
  implementation(project(":data-api:network-api"))

  implementation(libs.kotlin.serialization)
  implementation(libs.bundles.ktor)
}
