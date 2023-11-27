package com.deepfine.home.route

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

    data object Detail : ArgumentedRoute<FactModel> {
      override val parent: Route = Fact
      override val key: String = "fact"
    }
  }
}
