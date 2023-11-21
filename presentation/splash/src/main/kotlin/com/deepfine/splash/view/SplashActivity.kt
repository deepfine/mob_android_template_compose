package com.deepfine.splash.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.deepfine.home.view.MainActivity
import com.deepfine.splash.model.SplashSideEffect
import com.deepfine.splash.screen.SplashScreen
import com.deepfine.splash.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectSideEffect
import tech.thdev.compose.exteions.system.ui.controller.rememberExSystemUiController

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-09
 * @version 1.0.0
 */
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
  private val viewModel: SplashViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      viewModel.collectSideEffect(sideEffect = ::handleSideEffects)

      val systemUIController = rememberExSystemUiController()

      DisposableEffect(systemUIController) {
        systemUIController.setSystemBarsColor(Color.White)

        onDispose { }
      }

      SplashScreen()
    }
  }

  private fun handleSideEffects(sideEffect: SplashSideEffect) {
    when (sideEffect) {
      SplashSideEffect.NavigateToMain -> startActivity(MainActivity.newInstance(this))
    }
  }
}
