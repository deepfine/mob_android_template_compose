plugins {
  `kotlin-dsl`
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
  compileOnly(libs.android.gradlePlugin)
  compileOnly(libs.kotlin.gradlePlugin)
  compileOnly(libs.compose.compiler.extension)
}

gradlePlugin {
  plugins {
    register("PresentationPlugin") {
      id = "com.deepfine.presentation.plugin"
      implementationClass = "PresentationConventionPlugin"
    }

    register("AndroidPlugin") {
      id = "com.deepfine.android.plugin"
      implementationClass = "AndroidConventionPlugin"
    }

    register("HiltPlugin") {
      id = "com.deepfine.hilt.plugin"
      implementationClass = "HiltConventionPlugin"
    }
  }
}