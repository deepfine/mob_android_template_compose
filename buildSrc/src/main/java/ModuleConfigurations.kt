import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
fun BaseExtension.setLibraryConfig() {
  compileSdkVersion(AppConfiguration.COMPILE_SDK)
  buildToolsVersion(AppConfiguration.BUILD_TOOLS)

  defaultConfig {
    minSdk = AppConfiguration.MIN_SDK
    targetSdk = AppConfiguration.TARGET_SDK
  }

  sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}

fun BaseExtension.setViewBindingEnabled() {
  viewBinding {
    isEnabled = true
  }
}