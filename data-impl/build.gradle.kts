plugins {
  alias(libs.plugins.deepfine.android)
  alias(libs.plugins.deepfine.hilt)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "com.deepfine.data"
}

dependencies {
  implementation(projects.dataApi)
  implementation(projects.dataApi.networkApi)
  runtimeOnly(projects.dataImpl.networkImpl)

  implementation(libs.kotlin.serialization)
}
