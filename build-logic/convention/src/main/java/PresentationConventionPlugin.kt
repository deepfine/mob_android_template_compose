import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class PresentationConventionPlugin : AndroidConvention, HiltConvention, ComposeConvention {
  override fun apply(target: Project) {
    super<AndroidConvention>.apply(target)
    super<HiltConvention>.apply(target)
    super<ComposeConvention>.apply(target)

    with(target) {
      val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
      dependencies {
        add("implementation", project(":navigator"))
        add("implementation", project(":data-api"))
        add("runtimeOnly", project(":data-impl"))
      }
    }
  }
}