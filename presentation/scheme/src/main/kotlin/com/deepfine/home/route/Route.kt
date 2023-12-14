package com.deepfine.home.route

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.deepfine.presentation.ui.extensions.parseParcelable
import com.deepfine.presentation.ui.extensions.parseSerializable
import kotlinx.serialization.json.Json
import java.io.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
internal sealed interface Route {
  val parent: Route?
  val route: String
}

internal interface NavGraphRoot : Route {
  override val parent: Route?
    get() = null
  val destination: String
}

internal interface ArgumentedRoute : Route {
  val arguments: Map<String, NavType<*>>
  override val route: String
    get() = "${parent!!.route}?${
      arguments.keys.joinToString("&") { key ->
        "$key={$key}"
      }
    }"
}

internal fun ArgumentedRoute.createArgument(): List<NamedNavArgument> =
  arguments.map { (key, navType) ->
    navArgument(key) {
      type = navType
    }
  }

internal inline fun <reified T : Serializable> createSerializableNavType(isNullableAllowed: Boolean): NavType<T> = object : NavType<T>(isNullableAllowed) {
  override fun get(bundle: Bundle, key: String): T = bundle.parseSerializable(key, T::class.java)
  override fun parseValue(value: String): T = Json.decodeFromString(value)
  override fun put(bundle: Bundle, key: String, value: T) = bundle.putSerializable(key, value)
}

internal inline fun <reified T : Parcelable> createParcelableNavType(isNullableAllowed: Boolean): NavType<T> = object : NavType<T>(isNullableAllowed) {
  override fun get(bundle: Bundle, key: String): T = bundle.parseParcelable(key, T::class.java)
  override fun parseValue(value: String): T = Json.decodeFromString(value)
  override fun put(bundle: Bundle, key: String, value: T) = bundle.putParcelable(key, value)
}
