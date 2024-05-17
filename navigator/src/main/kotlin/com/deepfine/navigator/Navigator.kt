package com.deepfine.navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.deepfine.data.model.Fact
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val LocalNavigator = compositionLocalOf<Navigator> {
  error("No Navigator found!")
}

private class NavigatorImpl(
  private val navController: NavController,
) : Navigator {
  override val navigateUp: () -> Unit = {
    navController.navigateUp()
  }
  override val navigateToFact: (Fact) -> Unit = { fact ->
    navController.navigate("fact?fact=${Json.encodeToString(fact)}")
  }

  private fun NavController.navigateAsTop(route: String) {
    navigate(route) {
      popUpTo(0)
    }
  }
}

interface Navigator {
  val navigateUp: () -> Unit
  val navigateToFact: (Fact) -> Unit

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