plugins {
  alias(libs.plugins.deepfine.android)
  alias(libs.plugins.deepfine.hilt)
}

android {
  namespace = "com.deepfine.network"
}

dependencies {
  compileOnly(projects.buildconfigStub)
  implementation(projects.dataApi.networkApi)

  implementation(libs.kotlin.serialization)
  implementation(libs.bundles.ktor)
}
