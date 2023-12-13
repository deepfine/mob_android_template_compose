package com.deepfine.fact.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.deepfine.data.model.Fact
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@HiltViewModel
class FactDetailViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle
) : ViewModel() {
  val fact: Fact by lazy {
    savedStateHandle[ARG_FACT]!!
  }

  companion object {
    const val ARG_FACT = "fact"
  }
}
