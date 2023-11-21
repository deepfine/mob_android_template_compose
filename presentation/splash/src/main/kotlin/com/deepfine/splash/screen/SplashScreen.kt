package com.deepfine.splash.screen

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
import androidx.hilt.navigation.compose.hiltViewModel
import com.deepfine.presentation.ui.theme.ApplicationTheme
import com.deepfine.splash.model.SplashSideEffect
import com.deepfine.splash.viewModel.SplashViewModel
import org.orbitmvi.orbit.compose.collectSideEffect
import tech.thdev.compose.exteions.system.ui.controller.rememberExSystemUiController

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@Composable
fun SplashScreen(navigateToMain: () -> Unit = {}) {
  InternalSplashScreen(navigateToMain = navigateToMain)
}

@Composable
private fun InternalSplashScreen(viewModel: SplashViewModel = hiltViewModel(), navigateToMain: () -> Unit) {
  viewModel.collectSideEffect(sideEffect = { sideEffect ->
    handleSideEffect(sideEffect, navigateToMain)
  })

  val systemUIController = rememberExSystemUiController()
  DisposableEffect(systemUIController) {
    systemUIController.setSystemBarsColor(Color.White)
    onDispose {}
  }

  ApplicationTheme {
    Scaffold { paddingValues ->
      Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(
          paddingValues.toString(),
          textAlign = TextAlign.Center,
        )
      }
    }
  }
}

private fun handleSideEffect(sideEffect: SplashSideEffect, navigateToMain: () -> Unit) {
  when (sideEffect) {
    SplashSideEffect.NavigateToMain -> navigateToMain()
  }
}

@Composable
@Preview(showBackground = true)
private fun SplashScreenPreview() {
  SplashScreen()
}
