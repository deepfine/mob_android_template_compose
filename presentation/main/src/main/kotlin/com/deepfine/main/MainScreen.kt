package com.deepfine.main

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.deepfine.presentation.theme.ApplicationTheme

@Composable
fun MainScreen() {
  ApplicationTheme {
    Box {
    }
  }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
private fun MainScreenPreview() {
  MainScreen()
}
