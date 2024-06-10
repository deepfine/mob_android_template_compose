package com.deepfine.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import tech.thdev.compose.exteions.system.ui.controller.rememberExSystemUiController

@Composable
fun ApplicationTheme(
  systemBarsColor: Color = Color.White,
  statusBarColor: Color = systemBarsColor,
  navigationBarColor: Color = systemBarsColor,
  isSystemBarVisible: Boolean = true,
  isStatusBarVisible: Boolean = isSystemBarVisible,
  isNavigationBarVisible: Boolean = isSystemBarVisible,
  content: @Composable () -> Unit
) {
  val systemUIController = rememberExSystemUiController()

  DisposableEffect(systemUIController) {
    systemUIController.setSystemBarsColor(systemBarsColor)
    systemUIController.setStatusBarColor(statusBarColor)
    systemUIController.setNavigationBarColor(navigationBarColor)
    systemUIController.isSystemBarsVisible = isSystemBarVisible
    systemUIController.isStatusBarVisible = isStatusBarVisible
    systemUIController.isNavigationBarVisible = isNavigationBarVisible
    onDispose {}
  }

  MaterialTheme(
    colorScheme = ColorScheme,
    typography = Typography,
    content = content,
  )
}
