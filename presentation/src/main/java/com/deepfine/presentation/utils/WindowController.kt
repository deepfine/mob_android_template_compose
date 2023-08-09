package com.deepfine.presentation.utils

import android.graphics.Color
import android.view.Window
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.deepfine.presentation.R

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-05-31
 * @version 1.0.0
 */
class WindowController(private val window: Window?) {
  private val windowInsetsController: WindowInsetsControllerCompat? = window?.decorView?.let(ViewCompat::getWindowInsetsController)

  fun setFullScreenOverStatusBar() {
    if (window != null) {
      WindowCompat.setDecorFitsSystemWindows(window, false)
    }
  }

  fun showStatusBar() {
    windowInsetsController?.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    windowInsetsController?.show(WindowInsetsCompat.Type.statusBars())
  }

  fun setIsAppearanceLightStatusBars(isAppearanceLightStatusBars: Boolean) {
    windowInsetsController?.isAppearanceLightStatusBars = isAppearanceLightStatusBars
  }

  fun setNavigationBar(navigationBar: NavigationBar) {
    window?.navigationBarColor = navigationBar.color
    windowInsetsController?.isAppearanceLightNavigationBars = navigationBar.applyDarkIcons
  }

  fun showNavigationBar(navigationBar: NavigationBar) {
    setNavigationBar(navigationBar)
    windowInsetsController?.show(WindowInsetsCompat.Type.navigationBars())
  }

  fun hideNavigationBar() {
    windowInsetsController?.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    windowInsetsController?.hide(WindowInsetsCompat.Type.navigationBars())
  }

  fun enableDimBehind() {
    window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
  }

  fun disableDimBehind() {
    window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
  }

  fun setWindowAnimations(windowAnimation: WindowAnimation?) {
    windowAnimation?.let {
      window?.attributes?.windowAnimations = it.style
    }
  }
}

data class NavigationBar(
  @ColorInt val color: Int,
  val applyDarkIcons: Boolean = when (color) {
    Color.WHITE -> true
    Color.BLACK -> false
    else -> true
  }
)

enum class WindowAnimation(val style: Int) {
  FADE(R.style.FadeAnimation), POP_UP(R.style.PopupAnimation), SLIDE(R.style.SlideAnimation);
}