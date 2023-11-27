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

typealias FactModel = com.deepfine.domain.model.Fact

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

internal sealed class Screen(val route: String) {
  data object Fact : Screen("fact"), NavGraphRoot {
    override val destination: String = "factDest"

    data object Detail : Screen("${Fact.route}/{fact}"), Argumented<FactModel> {
      override val key: String = "fact"
    }
  }
}

internal interface NavGraphRoot {
  val destination: String
}

internal interface Argumented<T> {
  val key: String
}

internal inline fun <reified T> Argumented<T>.argumentedRoute(value: T): String =
  "$key/${Json.encodeToString(value)}"

@JvmName("createSerializableArgument")
internal inline fun <reified T : Serializable> Argumented<T>.createArgument(isNullableAllowed: Boolean): List<NamedNavArgument> =
  listOf(
    navArgument(key) {
      type = createSerializableNavType<T>(isNullableAllowed)
    },
  )

@JvmName("createParcelableArgument")
internal inline fun <reified T : Parcelable> Argumented<T>.createArgument(isNullableAllowed: Boolean): List<NamedNavArgument> =
  listOf(
    navArgument(key) {
      type = createParcelableNavType<T>(isNullableAllowed)
    },
  )

@JvmName("decodeSerializable")
internal inline fun <reified T : Serializable> Argumented<T>.decode(bundle: Bundle): T =
  bundle.parseSerializable(key, T::class.java)

@JvmName("decodeParcelable")
internal inline fun <reified T : Parcelable> Argumented<T>.decode(bundle: Bundle): T =
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
