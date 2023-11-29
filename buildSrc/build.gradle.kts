@file:Suppress("UnstableApiUsage")
repositories {
  google()
  mavenCentral()
  maven(url = "https://kotlin.bintray.com/kotlinx")
  maven(url = "https://www.jitpack.io")
}

plugins {
  `kotlin-dsl`
}

dependencies {
  implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
  implementation(libs.android.gradlePlugin)
  implementation(libs.kotlin.gradlePlugin)
  implementation(libs.kotlin.serialization.gradlePlugin)
  implementation(libs.hilt.gradlePlugin)
  implementation(libs.junit5.gradlePlugin)
}