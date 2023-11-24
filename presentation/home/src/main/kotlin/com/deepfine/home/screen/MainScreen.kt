package com.deepfine.home.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.deepfine.home.route.Screen
import com.deepfine.home.route.argumentedRoute
import com.deepfine.home.route.createArgument
import com.deepfine.home.route.decode
import com.deepfine.presentation.ui.extensions.requireArgument

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
      FactScreen({ fact -> navController.navigate(Screen.Fact.Detail.argumentedRoute(fact)) })
    }

    dialog(
      route = Screen.Fact.Detail.route,
      arguments = Screen.Fact.Detail.createArgument(false),
      dialogProperties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
        usePlatformDefaultWidth = false,
      ),
    ) { backStackEntry ->
      val fact = Screen.Fact.Detail.decode(backStackEntry.requireArgument())
      FactDialog(fact)
    }
  }
}
