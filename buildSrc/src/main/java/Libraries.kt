/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-08
 * @version 1.0.0
 */
object Libraries {
  object AndroidX {
    object Multidex : BaseLibrary(groupName = "androidx.multidex", name = "multidex", version = "2.0.1"), Implementable
    object Core : BaseLibrary(groupName = "androidx.core", name = "core-ktx", version = "1.10.1"), Implementable
    object AppCompat : BaseLibrary(groupName = "androidx.appcompat", name = "appcompat", version = "1.6.1"), Implementable
    object Activity : BaseLibrary(groupName = "androidx.activity", name = "activity-ktx", version = "1.7.2"), Implementable
    object Fragment : BaseLibrary(groupName = "androidx.fragment", name = "fragment-ktx", version = "1.6.1"), Implementable
  }

  object Google {
    object Material : BaseLibrary(groupName = "com.google.android.material", name = "material", version = "1.9.0"), Implementable
  }

  object Kotlin : LibraryGroup(groupName = "org.jetbrains.kotlin", version = "1.6.0") {
    object Coroutine : LibraryGroup(groupName = "org.jetbrains.kotlinx", version = "1.6.1") {
      object Core : LibraryGroupChild(group = Coroutine, name = "kotlinx-coroutines-core"), Implementable
      object Android : LibraryGroupChild(group = Coroutine, name = "kotlinx-coroutines-android"), Implementable
      object Test : LibraryGroupChild(group = Coroutine, name = "kotlinx-coroutines-test"), TestImplementable, Implementable
    }
  }

  object Lifecycle : LibraryGroup(groupName = "androidx.lifecycle", version = "2.4.1") {
    object LiveDataCore : LibraryGroupChild(group = Lifecycle, name = "lifecycle-livedata-core-ktx"), Implementable
    object LiveData : LibraryGroupChild(group = Lifecycle, name = "lifecycle-livedata-ktx"), Implementable
    object Runtime : LibraryGroupChild(group = Lifecycle, name = "lifecycle-runtime-ktx"), Implementable
    object ViewModel : LibraryGroupChild(group = Lifecycle, name = "lifecycle-viewmodel-ktx"), Implementable
  }

  object Ktor : LibraryGroup(groupName = "io.ktor", version = "1.5.0") {
    object Core : LibraryGroupChild(group = Ktor, name = "ktor-client-core"), Implementable
    object Android : LibraryGroupChild(group = Ktor, name = "ktor-client-android"), Implementable
    object Serialization : LibraryGroupChild(group = Ktor, name = "ktor-client-serialization"), Implementable
    object Logging : LibraryGroupChild(group = Ktor, name = "ktor-client-logging"), Implementable
    object Gson : LibraryGroupChild(group = Ktor, name = "ktor-client-gson"), Implementable
  }

  object Hilt : LibraryGroup(groupName = "com.google.dagger", version = "2.47"), Implementable, Library {
    override val name: String = "hilt-android"

    object AndroidCompiler : LibraryGroupChild(group = Hilt, name = "hilt-android-compiler"), Kapt
  }

  object TedPermission : BaseLibrary(groupName = "io.github.ParkSangGwon", name = "tedpermission-normal", version = "3.3.0"), Implementable
}