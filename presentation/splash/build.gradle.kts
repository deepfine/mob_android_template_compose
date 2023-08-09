plugins {
  androidLibrary()
  kotlinAndroid()
  hilt()
  kotlinKapt()
}

android {
  namespace = "com.deepfine.splash"
  setLibraryConfig()
  setViewBindingEnabled()
  setProductFlavors(project::property)
}

dependencies {
  projectImplementation(
    Modules.DOMAIN,
    Modules.PRESENTATION
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