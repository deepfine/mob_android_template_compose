package com.deepfine.home.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.deepfine.home.route.Route

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
      startDestination = Route.Main.id,
      Modifier.padding(paddingValues),
    ) {
      composable(route = Route.Main.id) {
        FactScreen({ navController.navigate(Route.Fact.id) })
      }

      dialog(route = Route.Fact.id) {
        FactDialog()
      }
    }
  }
}

@Composable
@Preview
private fun MainScreenPreview() {
  MainScreen()
}
