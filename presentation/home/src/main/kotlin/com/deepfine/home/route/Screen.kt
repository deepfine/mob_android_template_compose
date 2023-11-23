package com.deepfine.home.route

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
internal sealed class Screen(val route: String) {
  data object Fact : Screen("fact")
  data object FactDetail : Screen("factDetail")
}
