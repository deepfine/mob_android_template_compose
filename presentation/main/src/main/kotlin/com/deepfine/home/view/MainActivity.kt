package com.deepfine.home.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.deepfine.home.ui.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import tech.thdev.compose.exteions.system.ui.controller.rememberExSystemUiController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    installSplashScreen()

    setContent {
      val systemUIController = rememberExSystemUiController()

      DisposableEffect(systemUIController) {
        systemUIController.setSystemBarsColor(Color.White)

        onDispose { }
      }

      MainScreen()
    }
  }
}
