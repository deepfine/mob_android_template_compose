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

  hilt {
    enableAggregatingTask = true
  }

  testOptions.unitTests.all(Test::useJUnitPlatform)
}

dependencies {
  implementation(libs.findLibrary("kotlin.coroutine.core").get())
  implementation(libs.findLibrary("hilt").get())
  kapt(libs.findLibrary("hilt.compiler").get())

  testImplementation(libs.findBundle("test").get())
}