@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.deepfine.android.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}

android {
  namespace = "com.deepfine.network"

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
}

dependencies {
  implementation(project(":domain"))
  implementation(libs.bundles.ktor)
  testImplementation(libs.ktor.mock)
}
