package com.deepfine.splash.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.deepfine.home.view.MainActivity
import com.deepfine.presentation.ui.theme.ApplicationTheme
import com.deepfine.splash.model.SplashSideEffect
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

  @Composable
  @Preview(showBackground = true)
  fun SplashScreen() {
    ApplicationTheme {
      Scaffold { paddingValues ->
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
          Text(
            paddingValues.toString(),
            textAlign = TextAlign.Center
          )
        }
      }
    }
  }

  @Composable
  @Preview(showBackground = true)
  fun SplashScreenPreview() {
    SplashScreen()
  }
}
