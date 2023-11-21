package com.deepfine.home.route

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
internal sealed class Screen(val route: String) {
  data object Splash : Screen("splash")
  data object Main : Screen("main")
  data object Fact : Screen("fact")
}
