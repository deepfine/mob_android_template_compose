@file:Suppress("UnstableApiUsage")

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id(libs.plugins.kotlin.jvm.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
  id(libs.plugins.kotlin.serialization.get().pluginId)
}


dependencies {
  implementation(libs.kotlin.coroutine.core)
  implementation(libs.hilt.javax)
  implementation(libs.kotlin.serialization)
}
