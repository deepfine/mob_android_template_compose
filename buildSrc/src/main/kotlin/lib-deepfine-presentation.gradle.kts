/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@file:Suppress("UnstableApiUsage")

val versionCatalog = project.extensions.getByType<VersionCatalogsExtension>()
val libs: VersionCatalog = versionCatalog.named("libs")

plugins {
  id("com.android.library")
  id("dagger.hilt.android.plugin")
  kotlin("android")
  kotlin("kapt")
}

android {
  compileSdk = libs.findVersion("compileSdk").get().requiredVersion.toInt()

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }

  buildFeatures.compose = true
  composeOptions.kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().requiredVersion

  hilt {
    enableAggregatingTask = true
  }
}

dependencies {
  implementation(project(":data"))

  implementation(libs.findBundle("presentation").get())
  implementation(libs.findBundle("orbit").get())
  implementation(platform(libs.findLibrary("androidx.compose.bom").get()))
  implementation(libs.findBundle("compose").get())

  implementation(libs.findLibrary("hilt").get())
  kapt(libs.findLibrary("hilt.compiler").get())
}