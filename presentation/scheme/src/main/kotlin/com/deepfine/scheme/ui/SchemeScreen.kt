package com.deepfine.scheme.ui

import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.chandroidx.bottomsheetnavigator.ModalBottomSheetLayout
import com.chandroidx.bottomsheetnavigator.rememberBottomSheetNavigator
import com.deepfine.main.MainScreen
import com.deepfine.navigator.LocalNavigator
import com.deepfine.navigator.Navigator

@Composable
internal fun SchemeScreen() {
  val navigator = rememberBottomSheetNavigator()
  val navController = rememberNavController(navigator)

  CompositionLocalProvider(
    LocalNavigator provides Navigator.from(navController),
  ) {
    ModalBottomSheetLayout(
      modifier = Modifier.windowInsetsPadding(
        BottomSheetDefaults.windowInsets.only(
          WindowInsetsSides.Bottom,
        ),
      ),
      sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
      bottomSheetNavigator = navigator,
    ) {
      NavHost(
        navController = navController,
        startDestination = "navMain",
      ) {
        mainGraph()
      }
    }
  }
}

private fun NavGraphBuilder.mainGraph() {
  navigation(startDestination = "main", route = "navMain") {
    composable(route = "main") {
      MainScreen()
    }
  }
}
