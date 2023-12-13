@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  id(libs.plugins.android.library.get().pluginId)
}

android {
  namespace = "com.deepfine.buildconfig"

  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    buildConfigField("String", "VERSION_NAME", "String.valueOf(\"${libs.versions.versionName.get()}\")")
  }

  buildFeatures {
    buildConfig = true
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

}
