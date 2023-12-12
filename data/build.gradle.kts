@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.deepfine.android.get().pluginId)
}

android {
  namespace = "com.deepfine.data"

  flavorDimensions.add("api")
  productFlavors {
    create("dev")
    create("production")
  }
}

dependencies {
  implementation(project(":domain"))
  implementation(project(":data:network"))
}
