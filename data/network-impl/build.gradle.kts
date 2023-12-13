@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.deepfine.android.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}

android {
  namespace = "com.deepfine.network"
}

dependencies {
  compileOnly(project(":buildconfig-stub"))
  implementation(project(":data:network-api"))

  implementation(libs.bundles.ktor)
  testImplementation(libs.ktor.mock)
}
