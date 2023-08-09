plugins {
  androidLibrary()
  kotlinAndroid()
  hilt()
  kotlinKapt()
  kotlinSerialization()
}

android {
  namespace = "com.deepfine.network"
  setLibraryConfig()
  setProductFlavors(project::property)
}

dependencies {
  projectImplementation(
    Modules.DOMAIN,
  )

  implementation(
    Libraries.Ktor.Core,
    Libraries.Ktor.Android,
    Libraries.Ktor.Logging,
    Libraries.Ktor.Serialization,
    Libraries.Ktor.Gson,
  )

  implementation(
    Libraries.Kotlin.Coroutine.Core
  )

  implementation(
    Libraries.Hilt
  )

  kapt(
    Libraries.Hilt.AndroidCompiler
  )
}