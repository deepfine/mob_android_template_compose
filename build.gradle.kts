plugins {
  alias(libs.plugins.spotless)
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.hilt) apply false
  alias(libs.plugins.ksp) apply false
  alias(libs.plugins.compose.compiler) apply false
  alias(libs.plugins.kotlin.jvm) apply false
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

val addPreCommitGitHookOnBuild by tasks.registering {
  doLast {
    println("⚈ ⚈ ⚈ Running Add Pre Commit Git Hook Script on Build ⚈ ⚈ ⚈")

    providers.exec {
      commandLine("cp", "scripts/pre-commit", ".git/hooks")
    }.result.get()

    providers.exec {
      commandLine("chmod", "755", ".git/hooks/pre-commit")
    }.result.get()

    println("✅ Added Pre Commit Git Hook Script.")
  }
}

tasks.named("prepareKotlinBuildScriptModel") {
  dependsOn(addPreCommitGitHookOnBuild)
}