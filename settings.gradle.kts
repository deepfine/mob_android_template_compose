@file:Suppress("UnstableApiUsage")

pluginManagement {
  repositories {
    google {
      content {
        includeGroupByRegex("com\\.android.*")
        includeGroupByRegex("com\\.google.*")
        includeGroupByRegex("androidx.*")
      }
    }
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

include(
  ":app",
  ":buildconfig",
  ":buildconfig-stub",
  ":data-api",
  ":data-api:network-api",
  ":data-impl",
  ":data-impl:network-impl",
  ":navigator",
  ":presentation",
  ":presentation:scheme",
  ":presentation:main"
)
 