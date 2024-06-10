plugins {
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.kotlin.serialization)
}

dependencies {
  implementation(libs.kotlin.coroutine.core)
  implementation(libs.kotlin.serialization)
}