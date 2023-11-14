package com.deepfine.splash.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.deepfine.home.view.MainActivity
import com.deepfine.presentation.ui.theme.ApplicationTheme
import com.deepfine.presentation.ui.theme.WindowTheme
import com.deepfine.splash.model.SplashSideEffect
import com.deepfine.splash.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectSideEffect

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

      WindowTheme(
        decorFitsSystemWindows = true,
        statusBarColor = Color.White,
        isAppearanceLightStatusBars = true,
        navigationBarColor = Color.White,
        isAppearanceLightNavigationBars = true,
      )

      ApplicationTheme {
        Box(contentAlignment = Alignment.Center) {
          Text("Splash")
        }
      }
    }
  }

  private fun handleSideEffects(sideEffect: SplashSideEffect) {
    when (sideEffect) {
      SplashSideEffect.NavigateToMain -> startActivity(MainActivity.newInstance(this))
    }
  }

  @Composable
  @Preview
  fun SplashScreen() {
    ApplicationTheme {
      Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text("Splash")
      }
    }
  }
}
