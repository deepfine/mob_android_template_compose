package com.deepfine.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

val LocalNavigator = compositionLocalOf<Navigator> {
  error("No Navigator found!")
}

private class NavigatorImpl(
  private val navController: NavController,
) : Navigator {
  override val navigateUp: () -> Unit = {
    navController.navigateUp()
  }

  private fun NavController.navigateAsTop(route: String) {
    navigate(route) {
      popUpTo(0)
    }
  }
}

interface Navigator {
  val navigateUp: () -> Unit

  companion object {
    fun from(navController: NavController): Navigator = NavigatorImpl(navController)

    @Composable
    fun PreviewWrapper(content: @Composable () -> Unit) {
      CompositionLocalProvider(
        LocalNavigator provides from(rememberNavController()),
        content = content,
      )
    }
  }
}