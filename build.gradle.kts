// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("org.jlleitschuh.gradle.ktlint") version "10.3.0"
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
