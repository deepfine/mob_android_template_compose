plugins {
  alias(libs.plugins.android.library)
}

android {
  namespace = "com.deepfine.buildconfig"

  compileSdk = libs.versions.compileSdk.get().toInt()

  buildFeatures.buildConfig = true

  defaultConfig {
    buildConfigField("String", "VERSION_NAME", "String.valueOf(\"0\")")
    buildConfigField("String", "FLAVOR", "String.valueOf(\"0\")")
    buildConfigField("String", "API_URL", "String.valueOf(\"\")")
  }
}
