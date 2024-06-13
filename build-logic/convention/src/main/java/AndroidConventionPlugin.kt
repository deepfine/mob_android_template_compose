import com.android.build.gradle.LibraryExtension
import com.deepfine.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidConventionPlugin : AndroidConvention

internal interface AndroidConvention : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      with(pluginManager) {
        apply("com.android.library")
        apply("org.jetbrains.kotlin.android")
      }

      val extension = extensions.getByType<LibraryExtension>()
      configureKotlinAndroid(extension)

      extensions.getByType<KotlinAndroidProjectExtension>().apply {
        compilerOptions.freeCompilerArgs.addAll(
          "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        )
      }

      val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
      dependencies {
        add("implementation", libs.findLibrary("kotlin-coroutine-core").get())
        add("implementation", libs.findLibrary("androidx-core-ktx").get())
      }
    }
  }
}