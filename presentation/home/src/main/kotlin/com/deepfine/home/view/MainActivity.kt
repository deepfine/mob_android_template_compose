package com.deepfine.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.deepfine.home.route.Route
import com.deepfine.home.screen.FactDialog
import com.deepfine.home.screen.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import tech.thdev.compose.exteions.system.ui.controller.rememberExSystemUiController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      val systemUIController = rememberExSystemUiController()

      DisposableEffect(systemUIController) {
        systemUIController.setSystemBarsColor(Color.White)

        onDispose { }
      }

      val navController = rememberNavController()

      Scaffold { paddingValues ->
        NavHost(
          navController = navController,
          startDestination = Route.Main.id,
          Modifier.padding(paddingValues)
        ) {
          composable(route = Route.Main.id) {
            MainScreen({ navController.navigate(Route.Fact.id) })
          }

          dialog(route = Route.Fact.id) {
            FactDialog()
          }
        }
      }

    }
  }

  companion object {
    fun newInstance(context: Context) = Intent(context, MainActivity::class.java)
  }
}
