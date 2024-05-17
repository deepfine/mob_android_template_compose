plugins {
  id(libs.plugins.kotlin.jvm.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}

dependencies {
  implementation(libs.kotlin.coroutine.core)

  implementation(libs.kotlin.serialization)
}
