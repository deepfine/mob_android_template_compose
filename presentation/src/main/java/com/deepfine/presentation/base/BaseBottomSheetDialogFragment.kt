package com.deepfine.presentation.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.deepfine.presentation.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * @Description BaseBottomSheetDialogFragment
 * @author yc.park (DEEP.FINE)
 * @since 2021-03-31
 * @version 1.0.0
 */
abstract class BaseBottomSheetDialogFragment<B : ViewBinding, VM : BaseViewModel> : BottomSheetDialogFragment() {
  //================================================================================================
  // Properties
  //================================================================================================
  protected lateinit var binding: B
  protected abstract val bindingFactory: (LayoutInflater, ViewGroup?) -> B
  protected abstract val viewModel: VM

  //================================================================================================
  // Lifecycle
  //================================================================================================
  override fun onStart() {
    super.onStart()

    dialog?.let {
      val bottomSheet: View = dialog!!.findViewById(com.google.android.material.R.id.design_bottom_sheet)
      BottomSheetBehavior.from(bottomSheet).apply {
        state = BottomSheetBehavior.STATE_EXPANDED
        isHideable = false
      }
    }
  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    return BottomSheetDialog(requireContext(), R.style.CustomBottomSheetDialogFragment).apply {
      setCanceledOnTouchOutside(true)
    }
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = bindingFactory(inflater, container)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    onBind()
    initView()

  }

  //================================================================================================
  // Abstract
  //================================================================================================
  protected abstract fun onBind()
  protected abstract fun initView()
}