package com.deepfine.home.route

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.deepfine.presentation.ui.extensions.parseParcelable
import com.deepfine.presentation.ui.extensions.parseSerializable
import kotlinx.serialization.encodeToString
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
  val destination: String
}

internal interface ArgumentedRoute<T> : Route {
  val key: String
  override val route: String
    get() = "${parent!!.route}/{$key}"
}

internal inline fun <reified T> ArgumentedRoute<T>.argumentedRoute(value: T): String =
  "${parent!!.route}/${Json.encodeToString(value)}"

@JvmName("createSerializableArgument")
internal inline fun <reified T : Serializable> ArgumentedRoute<T>.createArgument(isNullableAllowed: Boolean): List<NamedNavArgument> =
  listOf(
    navArgument(key) {
      type = createSerializableNavType<T>(isNullableAllowed)
    },
  )

@JvmName("createParcelableArgument")
internal inline fun <reified T : Parcelable> ArgumentedRoute<T>.createArgument(isNullableAllowed: Boolean): List<NamedNavArgument> =
  listOf(
    navArgument(key) {
      type = createParcelableNavType<T>(isNullableAllowed)
    },
  )

@JvmName("decodeSerializable")
internal inline fun <reified T : Serializable> ArgumentedRoute<T>.decode(bundle: Bundle): T =
  bundle.parseSerializable(key, T::class.java)

@JvmName("decodeParcelable")
internal inline fun <reified T : Parcelable> ArgumentedRoute<T>.decode(bundle: Bundle): T =
  bundle.parseParcelable(key, T::class.java)

private inline fun <reified T : Serializable> createSerializableNavType(isNullableAllowed: Boolean): NavType<T> = object : NavType<T>(isNullableAllowed) {
  override fun get(bundle: Bundle, key: String): T = bundle.parseSerializable(key, T::class.java)
  override fun parseValue(value: String): T = Json.decodeFromString(value)
  override fun put(bundle: Bundle, key: String, value: T) = bundle.putSerializable(key, value)
}

private inline fun <reified T : Parcelable> createParcelableNavType(isNullableAllowed: Boolean): NavType<T> = object : NavType<T>(isNullableAllowed) {
  override fun get(bundle: Bundle, key: String): T = bundle.parseParcelable(key, T::class.java)
  override fun parseValue(value: String): T = Json.decodeFromString(value)
  override fun put(bundle: Bundle, key: String, value: T) = bundle.putParcelable(key, value)
}
