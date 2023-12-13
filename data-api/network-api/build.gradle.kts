@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  id(libs.plugins.kotlin.jvm.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}

dependencies {
  implementation(libs.kotlin.serialization)
  implementation(libs.kotlin.coroutine.core)
  implementation(libs.sandwich)
}
