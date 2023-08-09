package com.deepfine.presentation.base

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.deepfine.presentation.R
import com.deepfine.presentation.utils.DeepFineIndicator
import com.deepfine.presentation.utils.NavigationBar
import com.deepfine.presentation.utils.WindowAnimation
import com.deepfine.presentation.utils.WindowController

/**
 * @Description BaseDialogFragment
 * @author yc.park (DEEP.FINE)
 * @since 2021-03-09
 * @version 1.0.0
 */
abstract class BaseDialogFragment<B : ViewBinding, VM : BaseViewModel> : DialogFragment() {
  //================================================================================================
  // Properties
  //================================================================================================
  protected lateinit var binding: B
  protected abstract val bindFactory: (LayoutInflater, ViewGroup?, Boolean) -> B
  protected abstract val viewModel: VM
  protected open val animation: WindowAnimation? = null
  protected open val applyLayoutOverSystemUI: Boolean = false

  protected open val navigationBar: NavigationBar = NavigationBar(Color.WHITE, true)
  protected open val isAppearanceLightStatusBars = true

  protected val windowController: WindowController by lazy {
    WindowController(dialog?.window)
  }

  //================================================================================================
  // Lifecycle
  //================================================================================================
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (applyLayoutOverSystemUI) {
      setStyle(STYLE_NO_TITLE, R.style.DialogFragmentOverSystemTheme)
    } else {
      setStyle(STYLE_NO_TITLE, R.style.DialogFragmentTheme)
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    windowController.setWindowAnimations(animation)
    binding = bindFactory(inflater, container, false)
    return binding.root
  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    return object : Dialog(requireContext(), theme) {
      override fun onBackPressed() {
        onBackPressedDialog()
      }

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (applyLayoutOverSystemUI)
          windowController.setFullScreenOverStatusBar()
      }
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    windowController.setNavigationBar(navigationBar)
    windowController.setIsAppearanceLightStatusBars(isAppearanceLightStatusBars)

    onBind()
    initView()
  }

  //================================================================================================
  // Abstract
  //================================================================================================
  protected abstract fun onBind()
  protected abstract fun initView()

  protected open fun onBackPressedDialog() {
    super.dismiss()
  }

  //================================================================================================
  // Observe
  //================================================================================================
  protected fun showLoading() {
    DeepFineIndicator.showLoading(requireContext())
  }

  protected fun hideLoading() {
    DeepFineIndicator.hideLoading()
  }
}