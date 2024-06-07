repositories {
  google()
  mavenCentral()
  maven(url = "https://kotlin.bintray.com/kotlinx")
  maven(url = "https://www.jitpack.io")
  gradlePluginPortal()
}

plugins {
  `kotlin-dsl`
  `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
  implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
  implementation(libs.android.gradlePlugin)
  implementation(libs.kotlin.gradlePlugin)
  implementation(libs.kotlin.serialization.gradlePlugin)
  implementation(libs.hilt.gradlePlugin)
  implementation(libs.junit5.gradlePlugin)

  implementation(libs.compose.compiler.extension)
}