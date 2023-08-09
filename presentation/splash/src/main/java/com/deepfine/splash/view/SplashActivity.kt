package com.deepfine.splash.view

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.deepfine.domain.model.Sample
import com.deepfine.presentation.base.BaseActivity
import com.deepfine.presentation.extensions.repeatOnStarted
import com.deepfine.splash.databinding.ActivitySplashBinding
import com.deepfine.splash.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-09
 * @version 1.0.0
 */
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
  override val bindFactory: (LayoutInflater) -> ActivitySplashBinding = ActivitySplashBinding::inflate
  override val viewModel: SplashViewModel by viewModels()

  //================================================================================================
  // Initialize
  //================================================================================================
  override fun onBind() {
    repeatOnStarted(
      { viewModel.sample.collect(::observeSample) }
    )
  }

  override fun initView() {
  }

  //================================================================================================
  // Observe
  //================================================================================================
  private fun observeSample(sample: Sample) {
    binding.sampleTextView.text = sample.toString()
  }
}