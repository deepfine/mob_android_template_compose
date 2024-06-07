plugins {
  alias(libs.plugins.ksp) apply false
  alias(libs.plugins.spotless)
  id(libs.plugins.android.application.get().pluginId) apply false
  id(libs.plugins.android.library.get().pluginId) apply false
  id(libs.plugins.kotlin.android.get().pluginId) apply false
  id(libs.plugins.kotlin.parcelize.get().pluginId) apply false
  id(libs.plugins.kotlin.serialization.get().pluginId) apply false
  id(libs.plugins.hilt.get().pluginId) apply false
  id(libs.plugins.kotlin.kapt.get().pluginId) apply false
  id(libs.plugins.compose.compiler.get().pluginId) apply false
}

subprojects {
  apply(plugin = rootProject.libs.plugins.spotless.get().pluginId)
  configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
      target("**/*.kt")
      targetExclude("${layout.buildDirectory}/**/*.kt")
      ktlint().editorConfigOverride(
        mapOf(
          "indent_size" to "2",
          "continuation_indent_size" to "2",
          "ktlint_standard_function-naming" to "disabled",
          "ktlint_standard_property-naming" to "disabled",
          "ij_kotlin_allow_trailing_comma" to "false"
        )
      )
      trimTrailingWhitespace()
      endWithNewline()
    }
    format("kts") {
      target("**/*.kts")
      targetExclude("${layout.buildDirectory}/**/*.kts")
      trimTrailingWhitespace()
      endWithNewline()
    }
  }
}