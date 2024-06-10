plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.hilt)
  alias(libs.plugins.ksp)
}

android {
  namespace = libs.versions.applicationId.get()
  compileSdk = libs.versions.compileSdk.get().toInt()

  defaultConfig {
    applicationId = libs.versions.applicationId.get()
    minSdk = libs.versions.minSdk.get().toInt()
    targetSdk = libs.versions.targetSdk.get().toInt()
    versionCode = libs.versions.versionCode.get().toInt()
    versionName = libs.versions.versionName.get()
  }

  flavorDimensions.add("api")


  productFlavors {
    // 개발계
    create("dev") {
      resValue("string", "app_name", libs.versions.applicationName.get())
      resValue("string", "applicationId", libs.versions.applicationId.get() + applicationIdSuffix)
    }

    create("production") {
      resValue("string", "app_name", libs.versions.applicationName.get())
      resValue("string", "applicationId", libs.versions.applicationId.get())
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
}

dependencies {
  implementation(project(":buildconfig"))
  implementation(project(":presentation:scheme"))
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.multidex)
  implementation(libs.hilt)
  implementation(libs.splashScreen)
  ksp(libs.hilt.compiler)
}
