@file:Suppress("UnstableApiUsage")

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
