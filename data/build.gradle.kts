plugins {
  androidLibrary()
  kotlinAndroid()
  hilt()
  kotlinKapt()
}

android {
  namespace = "com.deepfine.data"
  setLibraryConfig()
  setProductFlavors(project::property)
}

dependencies {
  projectImplementation(
    Modules.DOMAIN,
    Modules.DATA_NETWORK
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