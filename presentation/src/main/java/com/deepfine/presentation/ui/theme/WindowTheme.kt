package com.deepfine.presentation.ui.theme

import android.app.Activity
import android.view.Window
import androidx.annotation.ColorInt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Composable
fun WindowTheme(
  decorFitsSystemWindows: Boolean = true,
  statusBarColor: Color = ColorScheme.primary,
  isAppearanceLightStatusBars: Boolean = true,
  navigationBarColor: Color = ColorScheme.primary,
  isAppearanceLightNavigationBars: Boolean = true,
  windowAnimation: WindowAnimation? = null
) {
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)

      decorFitsSystemWindows(window, decorFitsSystemWindows)
      setStatusBarColor(window, statusBarColor.toArgb())
      setAppearanceLightStatusBars(windowInsetsController, isAppearanceLightStatusBars)
      setNavigationBarColor(window, navigationBarColor.toArgb())
      setAppearanceLightNavigationBars(windowInsetsController, isAppearanceLightNavigationBars)
      setWindowAnimation(window, windowAnimation)
    }
  }
}

private fun decorFitsSystemWindows(window: Window, decorFitsSystemWindows: Boolean) {
  WindowCompat.setDecorFitsSystemWindows(window, decorFitsSystemWindows)
}

private fun setStatusBarColor(window: Window, @ColorInt color: Int) {
  window.statusBarColor = color
}

private fun setAppearanceLightStatusBars(windowInsetsController: WindowInsetsControllerCompat, isAppearanceLightStatusBars: Boolean) {
  windowInsetsController.isAppearanceLightStatusBars = isAppearanceLightStatusBars
}

private fun setNavigationBarColor(window: Window, @ColorInt color: Int) {
  window.navigationBarColor = color
}

private fun setAppearanceLightNavigationBars(windowInsetsController: WindowInsetsControllerCompat, isAppearanceLightNavigationBars: Boolean) {
  windowInsetsController.isAppearanceLightNavigationBars = isAppearanceLightNavigationBars
}

private fun setWindowAnimation(window: Window, animation: WindowAnimation?) {
  if (animation == null) return

  window.attributes.windowAnimations = animation.style
}

