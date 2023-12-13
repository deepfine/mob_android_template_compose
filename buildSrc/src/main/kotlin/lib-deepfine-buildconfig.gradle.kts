/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@file:Suppress("UnstableApiUsage")

val versionCatalog = project.extensions.getByType<VersionCatalogsExtension>()
val libs: VersionCatalog = versionCatalog.named("libs")

plugins {
  id("com.android.library")
}

android {
  namespace = "com.deepfine.buildconfig"

  compileSdk = libs.findVersion("compileSdk").get().requiredVersion.toInt()

  buildFeatures {
    buildConfig = true
  }

  flavorDimensions.add("api")
}