plugins {
  id(libs.plugins.deepfine.buildconfig.get().pluginId)
}

android {
  defaultConfig {
    buildConfigField("String", "VERSION_NAME", "String.valueOf(\"${libs.versions.versionName.get()}\")")
  }

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
