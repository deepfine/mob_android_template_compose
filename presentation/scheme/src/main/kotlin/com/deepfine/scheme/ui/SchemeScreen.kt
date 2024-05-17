package com.deepfine.scheme.ui

import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.chandroidx.bottomsheetnavigator.ModalBottomSheetLayout
import com.chandroidx.bottomsheetnavigator.bottomSheet
import com.chandroidx.bottomsheetnavigator.rememberBottomSheetNavigator
import com.deepfine.fact.ui.FactDetailDialog
import com.deepfine.fact.ui.FactScreen
import com.deepfine.navigator.LocalNavigator
import com.deepfine.navigator.Navigator
import com.deepfine.scheme.route.Screen
import com.deepfine.scheme.route.createArgument

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SchemeScreen() {
  val navigator = rememberBottomSheetNavigator()
  val navController = rememberNavController(navigator)

  CompositionLocalProvider(
    LocalNavigator provides Navigator.from(navController)
  ) {
    ModalBottomSheetLayout(
      modifier = Modifier.windowInsetsPadding(
        BottomSheetDefaults.windowInsets.only(
          WindowInsetsSides.Bottom
        )
      ),
      sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
      bottomSheetNavigator = navigator,
    ) {
      NavHost(
        navController = navController,
        startDestination = Screen.Fact.destination,
      ) {
        factGraph(navController)
      }
    }
  }
}

private fun NavGraphBuilder.factGraph(navController: NavController) {
  navigation(startDestination = Screen.Fact.route, route = Screen.Fact.destination) {
    composable(route = Screen.Fact.route) {
      FactScreen({ fact -> navController.navigate(Screen.Fact.Detail.argumentedRoute(fact)) })
    }

    dialog(
      route = Screen.Fact.Detail.route,
      arguments = Screen.Fact.Detail.createArgument(),
      dialogProperties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
        usePlatformDefaultWidth = false,
      ),
    ) { _ ->
      FactDetailDialog()
    }
  }
}
