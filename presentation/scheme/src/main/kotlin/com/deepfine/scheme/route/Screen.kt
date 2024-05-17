package com.deepfine.scheme.route

import androidx.navigation.NavType
import com.deepfine.data.model.Fact
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

typealias FactModel = Fact

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

object Screen {
  internal data object Fact : NavGraphRoot {
    override val destination: String = "navFact"
    override val route: String = "fact"

    data object Detail : ArgumentedRoute {
      override val parent: Route = Fact
      override val arguments: Map<String, NavType<*>>
        get() = mapOf(
          "fact" to createSerializableNavType<FactModel>(false),
        )

      fun argumentedRoute(fact: FactModel): String = "${parent.route}?fact=${Json.encodeToString(fact)}"
    }
  }
}
