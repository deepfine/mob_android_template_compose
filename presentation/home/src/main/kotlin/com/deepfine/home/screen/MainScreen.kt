package com.deepfine.home.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.deepfine.home.route.Screen
import com.deepfine.splash.screen.SplashScreen

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@Composable
internal fun MainScreen() {
  val navController = rememberNavController()

  Scaffold { paddingValues ->
    NavHost(
      navController = navController,
      startDestination = Screen.Splash.route,
      Modifier.padding(paddingValues),
    ) {
      composable(route = Screen.Splash.route) {
        SplashScreen(
          navigateToMain = {
            navController.navigate(Screen.Main.route) {
              popUpTo(Screen.Splash.route) {
                inclusive = true
              }
              launchSingleTop = true
            }
          },
        )
      }

      composable(route = Screen.Main.route) {
        FactScreen({ navController.navigate(Screen.Fact.route) })
      }

      dialog(route = Screen.Fact.route) {
        FactDialog()
      }
    }
  }
}
