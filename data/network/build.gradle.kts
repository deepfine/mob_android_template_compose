@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}

android {
  namespace = "com.deepfine.network"

  compileSdk = AppConfiguration.COMPILE_SDK

  compileOptions {
    sourceCompatibility = AppConfiguration.JAVA_VERSION
    targetCompatibility = AppConfiguration.JAVA_VERSION
  }

  flavorDimensions.add("api")

  productFlavors {
    // 개발계
    create("dev") {
      buildConfigField("String", "API_URL", project.property("api.url").toString())
    }

    create("production") {
      buildConfigField("String", "API_URL", project.property("production.api.url").toString())
    }
  }

  testOptions.unitTests.all(Test::useJUnitPlatform)
}

dependencies {
  implementation(project(":domain"))
  implementation(libs.bundles.ktor)
  implementation(libs.kotlin.coroutine.core)
  implementation(libs.hilt)

  kapt(libs.hilt.compiler.get())

  testImplementation(libs.ktor.mock)
  testImplementation(libs.bundles.test)
}
