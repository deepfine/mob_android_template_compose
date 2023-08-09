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

  packagingOptions {
    setExcludes(
      setOf(
        "AndroidManifest.xml",
        "META-INF/*",
        "META-INF/MANIFEST.MF",
        "META-INF/DEPENDENCIES",
        "META-INF/NOTICE",
        "META-INF/LICENSE",
        "META-INF/LICENSE.txt",
        "META-INF/LICENSE*",
        "META-INF/NOTICE.txt",
        "META-INF/ASL2.0",
        "META-INF/INDEX.LIST",
        "META-INF/proguard/coroutines.pro",
        "META-INF/com.android.tools/proguard/coroutines.pro",
        "build.xml"
      )
    )

    setDoNotStrip(
      setOf(
        "*/arm64-v8a/*.so"
      )
    )
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
}


fun BaseExtension.setProductFlavors(getProperty: (String) -> Any?, isAppConfig: Boolean = false) {
  flavorDimensions("api")

  productFlavors {
    // 개발계
    create("dev") {
      versionCode = AppConfiguration.VERSION_CODE
      versionName = AppConfiguration.VERSION_NAME
      buildConfigField("String", "VERSION_NAME", "\"${AppConfiguration.VERSION_NAME}\"")
      buildConfigField("Integer", "VERSION_CODE", AppConfiguration.VERSION_CODE.toString())
      buildConfigField("String", "API_URL", getProperty("api.url").toString())
      resValue("string", "app_name", AppConfiguration.APPLICATION_NAME)
      resValue("string", "applicationId", applicationId + applicationIdSuffix)
    }

    create("production") {
      versionCode = AppConfiguration.PRODUCTION_VERSION_CODE
      versionName = AppConfiguration.PRODUCTION_VERSION_NAME
      buildConfigField("String", "VERSION_NAME", "\"${AppConfiguration.VERSION_NAME}\"")
      buildConfigField("Integer", "VERSION_CODE", AppConfiguration.VERSION_CODE.toString())
      buildConfigField("String", "API_URL", getProperty("production.api.url").toString())
      resValue("string", "app_name", AppConfiguration.APPLICATION_NAME)
      resValue("string", "applicationId", AppConfiguration.APPLICATION_ID)
    }
  }
}

fun BaseExtension.setViewBindingEnabled() {
  viewBinding {
    isEnabled = true
  }
}