repositories {
  google()
  mavenCentral()
  maven(url = "https://kotlin.bintray.com/kotlinx")
  maven(url = "https://www.jitpack.io")
}

plugins {
  `kotlin-dsl` // java dsl 설정
}

dependencies {
  implementation("com.android.tools.build:gradle:8.0.2")
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.22")
  implementation("com.google.dagger:hilt-android-gradle-plugin:2.47")
  implementation("org.jetbrains.kotlin:kotlin-serialization:1.8.22")
}