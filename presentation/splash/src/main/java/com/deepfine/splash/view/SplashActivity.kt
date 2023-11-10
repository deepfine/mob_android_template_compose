package com.deepfine.splash.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.deepfine.presentation.ui.theme.ApplicationTheme
import com.deepfine.presentation.ui.theme.WindowAnimation
import com.deepfine.presentation.ui.theme.WindowTheme
import com.deepfine.splash.sideEffect.SplashSideEffect
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
      LaunchedEffect(true) {
        viewModel.sideEffects.collect(::observeSideEffects)
      }

      WindowTheme(
        decorFitsSystemWindows = true,
        statusBarColor = Color(0xFF62FF00).toArgb(),
        isAppearanceLightStatusBars = false,
        navigationBarColor = Color(0xFFFF0000).toArgb(),
        isAppearanceLightNavigationBars = false,
        windowAnimation = WindowAnimation.POP_UP
      )

      ApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          val state by viewModel.state.collectAsStateWithLifecycle()

          Column {
            Button({}, enabled = !state.loading) {
              Text("버튼")
            }
            Message(state.sample?.toString() ?: "")


          }

          Loading(state.loading)
        }
      }
    }
  }

  private fun observeSideEffects(sideEffect: SplashSideEffect) {
    when (sideEffect) {
      is SplashSideEffect.Error -> Toast.makeText(this, sideEffect.throwable.toString(), Toast.LENGTH_SHORT).show()
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

@Composable
fun Loading(loading: Boolean) {
  if (loading)
    Box {
      CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}


@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
  Loading(true)
}

@Preview(showBackground = true)
@Composable
fun MessagePreview() {
  ApplicationTheme {
    Message("Loading")
  }
}