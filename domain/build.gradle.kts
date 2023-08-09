plugins {
  androidLibrary()
  kotlinAndroid()
  hilt()
  kotlinKapt()
}

android {
  namespace = "com.deepfine.domain"
  setLibraryConfig()
  setProductFlavors(project::property)
}

dependencies {
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