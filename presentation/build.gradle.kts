plugins {
  androidLibrary()
  kotlinAndroid()
  hilt()
  kotlinKapt()
}

android {
  namespace = "com.deepfine.presentation"
  setLibraryConfig()
  setViewBindingEnabled()
  setProductFlavors(project::property)
}

dependencies {
  projectImplementation(
    Modules.DOMAIN
  )

  implementation(
    Libraries.Kotlin.Coroutine.Core,
    Libraries.AndroidX.Core,
    Libraries.AndroidX.AppCompat,
    Libraries.AndroidX.Activity,
    Libraries.AndroidX.Fragment,
    Libraries.Google.Material,
  )

  implementation(
    Libraries.Lifecycle.Runtime,
    Libraries.Lifecycle.ViewModel,
    Libraries.TedPermission,
  )

  implementation(
    Libraries.Hilt
  )

  kapt(
    Libraries.Hilt.AndroidCompiler
  )
}