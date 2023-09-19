package com.deepfine.splash.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.deepfine.presentation.ui.theme.ApplicationTheme
import com.deepfine.presentation.ui.theme.ColorScheme
import com.deepfine.presentation.ui.theme.Purple40
import com.deepfine.presentation.ui.theme.PurpleGrey40
import com.deepfine.presentation.ui.theme.WindowAnimation
import com.deepfine.presentation.ui.theme.WindowTheme
import com.deepfine.splash.state.SplashState
import com.deepfine.splash.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

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
      WindowTheme(
        decorFitsSystemWindows = false,
        statusBarColor = Purple40.toArgb(),
        isAppearanceLightStatusBars = false,
        navigationBarColor = PurpleGrey40.toArgb(),
        isAppearanceLightNavigationBars = false,
        windowAnimation = WindowAnimation.POP_UP
      )

      ApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          val state by viewModel.uiState.collectAsState()
          when (state) {
            is SplashState.Loading -> Message("Loading")
            is SplashState.LoadFailure -> Message("Failure")
            is SplashState.SampleLoaded -> Message((state as SplashState.SampleLoaded).sample.toString())
          }
        }
      }
    }
  }
}

@Composable
fun Message(message: String, modifier: Modifier = Modifier) {
  Text(
    text = message,
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  ApplicationTheme {
    Message("Loading")
  }
}