package com.deepfine.presentation.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @Description LifecycleOwner
 * @author yc.park (DEEP.FINE)
 * @since 2022-05-24
 * @version 1.0.0
 */

fun AppCompatActivity.repeatOnStarted(vararg blocks: suspend CoroutineScope.() -> Unit) {
  lifecycleScope.launch {
    blocks.forEach { block ->
      launch {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED, block)
      }
    }
  }
}

fun Fragment.repeatOnStarted(vararg blocks: suspend CoroutineScope.() -> Unit) {
  viewLifecycleOwner.lifecycleScope.launch {
    blocks.forEach { block ->
      launch {
        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED, block)
      }
    }
  }
}