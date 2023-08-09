package com.deepfine.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.deepfine.presentation.utils.DeepFineIndicator

/**
 * @Description BaseFragment
 * @author yc.park (DEEP.FINE)
 * @since 2021-09-30
 * @version 1.0.0
 */
abstract class BaseFragment<B : ViewBinding, VM : BaseViewModel> : Fragment() {
  //================================================================================================
  // Properties
  //================================================================================================
  protected lateinit var binding: B
  protected abstract val bindFactory: (LayoutInflater, ViewGroup?, Boolean) -> B
  protected abstract val viewModel: VM

  //================================================================================================
  // Lifecycle
  //================================================================================================
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    binding = bindFactory(inflater, container, false)
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