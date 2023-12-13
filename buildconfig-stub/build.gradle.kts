@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  id(libs.plugins.android.library.get().pluginId)
}

android {
  namespace = "com.deepfine.buildconfig"

  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    buildConfigField("String", "VERSION_NAME", "String.valueOf(\"0\")")
    buildConfigField("String", "API_URL", "String.valueOf(\"\")")
  }

  buildFeatures {
    buildConfig = true
  }

  flavorDimensions.add("api")
}
