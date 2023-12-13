@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.deepfine.android.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
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
