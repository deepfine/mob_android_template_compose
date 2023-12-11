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
  ":data:network",
  ":domain",
  ":presentation",
  ":presentation:scheme",
  ":presentation:fact"
).forEach(::include)
