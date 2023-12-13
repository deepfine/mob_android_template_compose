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
  ":data",
  ":data:network-api",
  ":data:network-impl",
  ":presentation",
  ":presentation:scheme",
  ":presentation:fact",
  ":buildconfig",
  ":buildconfig-stub"
).forEach(::include)
