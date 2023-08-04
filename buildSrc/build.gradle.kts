repositories {
  google()
  mavenCentral()
}

plugins {
  `kotlin-dsl` // java dsl 설정
}

dependencies {
  implementation("com.android.tools.build:gradle:7.3.0")
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.22")
}