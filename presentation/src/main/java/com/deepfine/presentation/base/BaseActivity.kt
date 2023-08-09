package com.deepfine.presentation.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.deepfine.presentation.utils.DeepFineIndicator
import com.deepfine.presentation.utils.WindowController

/**
 * @Description BaseActivity
 * @author yc.park (DEEP.FINE)
 * @since 2022-01-28
 * @version 1.0.0
 */
abstract class BaseActivity<B : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {
  //================================================================================================
  // Properties
  //================================================================================================
  protected lateinit var binding: B
  protected abstract val bindFactory: (LayoutInflater) -> B
  protected abstract val viewModel: VM
  protected val windowController: WindowController by lazy {
    WindowController(window)
  }

  //================================================================================================
  // Lifecycle
  //================================================================================================
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = bindFactory.invoke(layoutInflater)
    setContentView(binding.root)

    windowController.showStatusBar()
    windowController.setFullScreenOverStatusBar()
    onBind()
    initView()
  }

  //================================================================================================
  // Abstract
  //================================================================================================
  protected abstract fun onBind()
  protected abstract fun initView()

  //================================================================================================
  // Observe
  //================================================================================================
  protected fun showLoading() {
    DeepFineIndicator.showLoading(this)
  }

  protected fun hideLoading() {
    DeepFineIndicator.hideLoading()
  }

  //================================================================================================
  // Overrides
  //================================================================================================
  override fun attachBaseContext(newBase: Context) {
    val newConfig = Configuration(newBase.resources.configuration)

    if (newBase.resources.configuration.fontScale > MAX_FONT_SCALE) {
      newConfig.fontScale = MAX_FONT_SCALE
    }

    applyOverrideConfiguration(newConfig)
    super.attachBaseContext(newBase)
  }

  //================================================================================================
  // Functions
  //================================================================================================

  //================================================================================================
  // Companion
  //================================================================================================
  companion object {
    private const val MAX_FONT_SCALE = 1.7F
  }
}