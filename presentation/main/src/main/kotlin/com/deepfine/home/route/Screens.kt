package com.deepfine.home.route

import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

typealias FactModel = com.deepfine.domain.model.Fact

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

object Screen {
  internal data object Fact : NavGraphRoot {
    override val parent: Route? = null
    override val destination: String = "navFact"
    override val route: String = "fact"

    data object Detail : ArgumentedRoute {
      override val parent: Route = Fact
      override val keys: Set<Pair<String, NavType<*>>>
        get() = setOf(
          "fact" to createParcelableNavType<FactModel>(false),
        )

      fun argumentedRoute(fact: FactModel): String = "${parent.route}?fact=${Json.encodeToString(fact)}"
    }
  }
}
