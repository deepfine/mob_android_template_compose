@file:Suppress("UnstableApiUsage")

// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  alias(libs.plugins.ksp) apply false
  alias(libs.plugins.spotless)
  id(libs.plugins.android.application.get().pluginId) apply false
  id(libs.plugins.android.library.get().pluginId) apply false
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

  if (!name.contains("app")) {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
      kotlinOptions.jvmTarget = libs.versions.jvmTarget.get()
      kotlinOptions.freeCompilerArgs += listOf(
        "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
      )
    }
  }

  tasks.withType(JavaCompile::class.java).configureEach {
    this.targetCompatibility = libs.versions.jvmTarget.get()
    this.sourceCompatibility = libs.versions.jvmTarget.get()
  }
}
