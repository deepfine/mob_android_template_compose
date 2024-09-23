import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class ComposeConventionPlugin : ComposeConvention

internal interface ComposeConvention : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("org.jetbrains.kotlin.plugin.compose")
      }

      extensions.getByType<KotlinAndroidProjectExtension>().apply {
        compilerOptions.freeCompilerArgs.addAll(
          "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
          "-opt-in=androidx.compose.foundation.ExperimentalFoundationApi",
        )
      }

      extensions.getByType<BaseExtension>().apply {
        buildFeatures.compose = true
      }

      extensions.getByType<ComposeCompilerGradlePluginExtension>().apply {
        enableStrongSkippingMode.set(true)
        includeSourceInformation.set(true)
      }

      val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
      dependencies {
        add("implementation", platform(libs.findLibrary("androidx-compose-bom").get()))
        add("implementation", libs.findBundle("compose").get())
      }
    }
  }

}