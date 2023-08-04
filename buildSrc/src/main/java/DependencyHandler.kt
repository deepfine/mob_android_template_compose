import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

/**
 * Put in this file all the ways the libraries configurations can be added in the [DependencyHandler].
 */

fun DependencyHandler.projectImplementation(vararg path: String) {
  path.forEach { projectDependency ->
    add("implementation", project(projectDependency))
  }
}

fun DependencyHandler.debugImplementation(vararg dependencies: String) {
  dependencies.forEach { dependency ->
    add("debugImplementation", dependency)
  }
}

fun DependencyHandler.debugImplementation(vararg dependencies: Implementable) {
  dependencies.forEach { dependency ->
    add("debugImplementation", dependency.asString())
  }
}

fun DependencyHandler.implementation(vararg dependencies: Implementable) {
  dependencies.forEach { dependency ->
    add("implementation", dependency.asString())
  }
}

fun DependencyHandler.implementation(vararg dependencies: String) {
  dependencies.forEach { dependency ->
    add("implementation", dependency)
  }
}

fun DependencyHandler.testProjectImplementation(vararg path: String) {
  path.forEach { projectDependency ->
    add("testImplementation", project(projectDependency))
  }
}

fun DependencyHandler.testImplementation(vararg dependencies: TestImplementable) {
  dependencies.forEach { dependency ->
    add("testImplementation", dependency.asString())
  }
}

fun DependencyHandler.testRuntimeOnly(vararg dependencies: TestImplementable) {
  dependencies.forEach { dependency ->
    add("testRuntimeOnly", dependency.asString())
  }
}

fun DependencyHandler.androidTestImplementation(vararg dependencies: TestImplementable) {
  dependencies.forEach { dependency ->
    add("androidTestImplementation", dependency.asString())
  }
}

fun DependencyHandler.androidTestRuntimeOnly(vararg dependencies: TestImplementable) {
  dependencies.forEach { dependency ->
    add("androidTestRuntimeOnly", dependency.asString())
  }
}

fun DependencyHandler.kapt(vararg dependencies: Kapt) {
  dependencies.forEach { dependency ->
    add("kapt", dependency.asString())
  }
}

fun DependencyHandler.kapt(vararg dependencies: String) {
  dependencies.forEach { dependency ->
    add("kapt", dependency)
  }
}