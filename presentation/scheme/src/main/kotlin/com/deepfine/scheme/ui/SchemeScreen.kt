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
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.chandroidx.bottomsheetnavigator.ModalBottomSheetLayout
import com.chandroidx.bottomsheetnavigator.bottomSheet
import com.chandroidx.bottomsheetnavigator.rememberBottomSheetNavigator
import com.deepfine.fact.ui.FactDetailDialog
import com.deepfine.fact.ui.FactScreen
import com.deepfine.navigator.LocalNavigator
import com.deepfine.navigator.Navigator
import com.deepfine.scheme.route.FactModel
import com.deepfine.scheme.route.createArgument
import com.deepfine.scheme.route.createSerializableNavType

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

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
        startDestination = "navFact",
      ) {
        factGraph()
      }
    }
  }
}

private fun NavGraphBuilder.factGraph() {
  navigation(startDestination = "fact", route = "navFact") {
    composable(route = "fact") {
      FactScreen()
    }

    dialog(
      route = "fact?fact={fact}",
      arguments = listOf(
        navArgument("fact") {
          type = createSerializableNavType<FactModel>(false)
        }
      ),
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
