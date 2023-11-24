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
  data object Fact : Screen("fact")

  data object FactDetail : Screen("fact/{fact}"), Argumented<FactModel> {
    private const val KEY = "fact"

    override fun argumentedRoute(value: FactModel) = "fact/${Json.encodeToString(value)}"
    override val argument: List<NamedNavArgument>
      get() = listOf(
        navArgument(KEY) {
          type = createParcelableNavType<FactModel>(false)
        },
      )

    override fun decodeArgument(bundle: Bundle): FactModel =
      bundle.parseParcelable(KEY, FactModel::class.java)
  }
}

private interface Argumented<T> {
  fun argumentedRoute(value: T): String
  val argument: List<NamedNavArgument>
  fun decodeArgument(bundle: Bundle): T
}

private inline fun <reified T : Serializable> createSerializableNavType(isNullableAllowed: Boolean) = object : NavType<T>(isNullableAllowed) {
  override fun get(bundle: Bundle, key: String): T = bundle.parseSerializable(key, T::class.java)
  override fun parseValue(value: String): T = Json.decodeFromString(value)
  override fun put(bundle: Bundle, key: String, value: T) = bundle.putSerializable(key, value)
}

private inline fun <reified T : Parcelable> createParcelableNavType(isNullableAllowed: Boolean) = object : NavType<T>(isNullableAllowed) {
  override fun get(bundle: Bundle, key: String): T = bundle.parseParcelable(key, T::class.java)
  override fun parseValue(value: String): T = Json.decodeFromString(value)
  override fun put(bundle: Bundle, key: String, value: T) = bundle.putParcelable(key, value)
}
