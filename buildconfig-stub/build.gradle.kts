@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  id(libs.plugins.deepfine.buildconfig.get().pluginId)
}

android {
  defaultConfig {
    buildConfigField("String", "VERSION_NAME", "String.valueOf(\"0\")")
    buildConfigField("String", "API_URL", "String.valueOf(\"\")")
  }
}
