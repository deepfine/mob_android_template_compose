@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.android.application.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
  namespace = AppConfiguration.APPLICATION_ID

  defaultConfig {
    applicationId = AppConfiguration.APPLICATION_ID
    compileSdk = AppConfiguration.COMPILE_SDK
    minSdk = AppConfiguration.MIN_SDK
    targetSdk = AppConfiguration.TARGET_SDK
    versionCode = AppConfiguration.VERSION_CODE
    versionName = AppConfiguration.VERSION_NAME
  }

  flavorDimensions.add("api")

  productFlavors {
    // 개발계
    create("dev") {
      buildConfigField("String", "VERSION_NAME", "\"${AppConfiguration.VERSION_NAME}\"")
      buildConfigField("Integer", "VERSION_CODE", AppConfiguration.VERSION_CODE.toString())
      buildConfigField("String", "API_URL", project.property("api.url").toString())
      resValue("string", "app_name", AppConfiguration.APPLICATION_NAME)
      resValue("string", "applicationId", applicationId + applicationIdSuffix)
    }

    create("production") {
      versionCode = AppConfiguration.PRODUCTION_VERSION_CODE
      versionName = AppConfiguration.PRODUCTION_VERSION_NAME
      buildConfigField("String", "VERSION_NAME", "\"${AppConfiguration.VERSION_NAME}\"")
      buildConfigField("Integer", "VERSION_CODE", AppConfiguration.VERSION_CODE.toString())
      buildConfigField("String", "API_URL", project.property("production.api.url").toString())
      resValue("string", "app_name", AppConfiguration.APPLICATION_NAME)
      resValue("string", "applicationId", AppConfiguration.APPLICATION_ID)
    }
  }

  buildTypes {
    debug {
      isDebuggable = true
      isMinifyEnabled = false
      isShrinkResources = false
    }

    release {
      isDebuggable = false
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//            signingConfig = signingConfigs.getByName("release")
    }
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  lint {
    abortOnError = false
  }
}

dependencies {
  implementation(project(":data"))
  implementation(project(":domain"))
  implementation(project(":presentation:main"))

  implementation(libs.androidx.multidex)
  implementation(libs.androidx.ktx)
  implementation(libs.hilt)

  kapt(libs.hilt.compiler.get())
}
