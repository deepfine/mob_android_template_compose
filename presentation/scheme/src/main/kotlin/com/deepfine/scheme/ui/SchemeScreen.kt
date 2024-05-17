package com.deepfine.scheme.ui

import android.os.Bundle
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.chandroidx.bottomsheetnavigator.ModalBottomSheetLayout
import com.chandroidx.bottomsheetnavigator.rememberBottomSheetNavigator
import com.deepfine.data.model.Fact
import com.deepfine.fact.ui.FactDetailDialog
import com.deepfine.fact.ui.FactScreen
import com.deepfine.navigator.LocalNavigator
import com.deepfine.navigator.Navigator
import com.deepfine.presentation.ui.extensions.parseSerializable
import kotlinx.serialization.json.Json
import java.io.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

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
          type = createSerializableNavType<Fact>(false)
        },
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

internal inline fun <reified T : Serializable> createSerializableNavType(isNullableAllowed: Boolean): NavType<T> = object : NavType<T>(isNullableAllowed) {
  override fun get(bundle: Bundle, key: String): T = bundle.parseSerializable(key, T::class.java)
  override fun parseValue(value: String): T = Json.decodeFromString(value)
  override fun put(bundle: Bundle, key: String, value: T) = bundle.putSerializable(key, value)
}
