package com.deepfine.home.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.deepfine.home.route.Screen

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@Composable
internal fun MainScreen() {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = Screen.Fact.route,
  ) {
    composable(route = Screen.Fact.route) {
      FactScreen({ navController.navigate(Screen.FactDetail.route) })
    }

    dialog(route = Screen.FactDetail.route) {
      FactDialog()
    }
  }
}
