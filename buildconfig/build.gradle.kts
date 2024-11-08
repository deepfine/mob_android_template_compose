plugins {
  alias(libs.plugins.android.library)
}

android {
  namespace = "com.deepfine.buildconfig"

  compileSdk = libs.versions.compileSdk.get().toInt()

  buildFeatures.buildConfig = true

  defaultConfig {
    buildConfigField("String", "VERSION_NAME", "String.valueOf(\"${libs.versions.versionName.get()}\")")
  }

  flavorDimensions.add("api")

  productFlavors {
    // 개발계
    create("dev") {
      buildConfigField("String", "API_URL", project.property("api.url").toString())
      buildConfigField("String", "FLAVOR", "\"dev\"")
    }

    create("prod") {
      buildConfigField("String", "API_URL", project.property("prod.api.url").toString())
      buildConfigField("String", "FLAVOR", "\"prod\"")
    }
  }
}
