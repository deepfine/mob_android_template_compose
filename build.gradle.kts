@file:Suppress("UnstableApiUsage")

// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  alias(libs.plugins.ktlint)
  alias(libs.plugins.ksp) apply false
  id(libs.plugins.android.application.get().pluginId) apply false
  id(libs.plugins.android.library.get().pluginId) apply false
}

subprojects {
  apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
