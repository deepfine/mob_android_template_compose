package com.deepfine.splash.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.deepfine.presentation.ui.theme.ApplicationTheme

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Composable
internal fun SplashScreen() {
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

@Composable
@Preview(showBackground = true)
private fun SplashScreenPreview() {
  SplashScreen()
}
