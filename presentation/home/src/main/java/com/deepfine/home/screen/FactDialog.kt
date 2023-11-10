package com.deepfine.home.screen

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Composable
fun FactDialog() {
  Surface(
    color = Color.White, modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(0.5f)
  ) {
  }
}

@Composable
@Preview
fun FactDialogPreview() {
  FactDialog()
}