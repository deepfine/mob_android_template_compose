package com.deepfine.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
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

      MainScreen()
    }
  }

  companion object {
    fun newInstance(context: Context) = Intent(context, MainActivity::class.java)
  }
}
