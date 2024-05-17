@file:Suppress("UnstableApiUsage")

include(":navigator")


pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://www.jitpack.io")
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
    maven(url = "https://www.jitpack.io")
  }
}

listOf(
  ":app",
  ":data-api",
  ":data-impl",
  ":data-api:network-api",
  ":data-impl:network-impl",
  ":presentation",
  ":presentation:scheme",
  ":presentation:fact",
  ":buildconfig",
  ":buildconfig-stub"
).forEach(::include)
