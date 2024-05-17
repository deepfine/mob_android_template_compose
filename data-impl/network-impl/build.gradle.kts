plugins {
  id(libs.plugins.deepfine.android.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}

android {
  namespace = "com.deepfine.network"
}

dependencies {
  compileOnly(project(":buildconfig-stub"))
  implementation(project(":data-api:network-api"))

  implementation(libs.bundles.ktor)
  testImplementation(libs.ktor.mock)
}
