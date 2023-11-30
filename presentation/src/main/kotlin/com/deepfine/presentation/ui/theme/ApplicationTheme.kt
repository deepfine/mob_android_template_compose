package com.deepfine.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import tech.thdev.compose.exteions.system.ui.controller.rememberExSystemUiController

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

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
    systemUIController.setStatusBarColor(statusBarColor)
    systemUIController.setNavigationBarColor(navigationBarColor)
    systemUIController.setSystemBarsColor(systemBarsColor)
    systemUIController.isStatusBarVisible = isStatusBarVisible
    systemUIController.isNavigationBarVisible = isNavigationBarVisible
    systemUIController.isSystemBarsVisible = isSystemBarVisible
    onDispose { }
  }

  MaterialTheme(
    colorScheme = ColorScheme,
    typography = Typography,
    content = content,
  )
}
