import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

class PresentationConventionPlugin : AndroidConvention, HiltConvention {
  override fun apply(target: Project) {
    super<AndroidConvention>.apply(target)
    super<HiltConvention>.apply(target)

    with(target) {
      with(pluginManager) {
        apply("org.jetbrains.kotlin.plugin.compose")
      }

      extensions.getByType<ComposeCompilerGradlePluginExtension>().apply {
        enableStrongSkippingMode.set(true)
        includeSourceInformation.set(true)
      }

      val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
      dependencies {
        add("implementation", project(":navigator"))
        add("implementation", project(":data-api"))
        add("runtimeOnly", project(":data-impl"))

        add("implementation", libs.findLibrary("androidx-core-ktx").get())
        add("implementation", platform(libs.findLibrary("androidx-compose-bom").get()))
        add("implementation", libs.findBundle("orbit").get())
        add("implementation", libs.findBundle("compose").get())
      }
    }
  }
}