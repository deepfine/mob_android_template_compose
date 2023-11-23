package com.deepfine.home.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.deepfine.presentation.ui.theme.ApplicationTheme

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Composable
internal fun FactDialog() {
  ApplicationTheme {
    Surface(
      color = Color.White,
      modifier = Modifier
        .fillMaxSize(),
    ) {
    }
  }
}

@Composable
@Preview
private fun FactDialogPreview() {
  FactDialog()
}
