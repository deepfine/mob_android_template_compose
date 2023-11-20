@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
  namespace = "com.deepfine.data"
  setLibraryConfig()

  flavorDimensions.add("api")
  productFlavors {
    create("dev")
    create("production")
  }

  testOptions.unitTests.all(Test::useJUnitPlatform)
}

dependencies {
  implementation(project(":domain"))
  implementation(project(":data:network"))

  implementation(libs.kotlin.coroutine.core)
  implementation(libs.hilt)

  kapt(libs.hilt.compiler.get())

  testImplementation(libs.bundles.test)
}
