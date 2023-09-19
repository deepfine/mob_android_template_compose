package com.deepfine.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@Composable
fun ApplicationTheme(
  content: @Composable () -> Unit
) {
  MaterialTheme(
    colorScheme = ColorScheme,
    typography = Typography,
    content = content
  )
}
