@file:Suppress("UnstableApiUsage")

plugins {
  androidApp()
  kotlinAndroid()
  hilt()
  kotlinKapt()
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

  setProductFlavors(project::property, true)

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

  kotlinOptions {
    jvmTarget = "17"
  }
}

dependencies {
  projectImplementation(
    Modules.DATA,
    Modules.DOMAIN,
    Modules.PRESENTATION_SPLASH
  )

  implementation(
    Libraries.AndroidX.Core,
    Libraries.AndroidX.AppCompat,
    Libraries.Google.Material,
  )

  implementation(
    Libraries.AndroidX.Multidex
  )

  implementation(
    Libraries.Hilt
  )

  kapt(
    Libraries.Hilt.AndroidCompiler
  )
}
