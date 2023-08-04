import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * @Description Class
 * @author yc.park (DEEP.FINE)
 * @since 2023-02-13
 * @version 1.0.0
 */


//val PluginDependenciesSpec.ktlint: PluginDependencySpec
//  get() = id("org.jlleitschuh.gradle.ktlint").version("9.4.1")

fun PluginDependenciesSpec.androidApp(): PluginDependencySpec =
  id("com.android.application")

fun PluginDependenciesSpec.androidLibrary(): PluginDependencySpec =
  id("com.android.library")

fun PluginDependenciesSpec.hilt(): PluginDependencySpec =
  id("dagger.hilt.android.plugin")

fun PluginDependenciesSpec.jUnit5(): PluginDependencySpec =
  id("de.mannodermaus.android-junit5")


fun PluginDependenciesSpec.kotlinKapt(): PluginDependencySpec =
  kotlin("kapt")

fun PluginDependenciesSpec.kotlinParcelize(): PluginDependencySpec =
  id("kotlin-parcelize")

/**
 * Android Kotlin module
 */
fun PluginDependenciesSpec.kotlinAndroid(): PluginDependencySpec =
  id("org.jetbrains.kotlin.android")

fun PluginDependenciesSpec.navigation(): PluginDependencySpec =
  id("androidx.navigation.safeargs.kotlin")