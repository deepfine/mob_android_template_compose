package com.deepfine.fact.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepfine.data.model.Fact
import com.deepfine.data.repository.FactRepository
import com.deepfine.fact.model.FactSideEffect
import com.deepfine.fact.model.FactState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@HiltViewModel
class FactViewModel @Inject constructor(
  private val repository: FactRepository
) : ViewModel(), ContainerHost<FactState, FactSideEffect> {

  override val container = container<FactState, FactSideEffect>(FactState())

  init {
    requestFacts()
  }

  fun requestFacts() = intent {
    viewModelScope.launch {
      reduce { state.copy(loading = true) }
      repository.getFacts().collect { result ->
        result.fold(::onFetchFactsSuccess, ::onFetchFactsFailure)
      }
    }
  }

  private fun onFetchFactsSuccess(facts: List<Fact>) = intent {
    reduce { state.copy(loading = false, facts = facts, error = null) }
  }

  private fun onFetchFactsFailure(throwable: Throwable) = intent {
    reduce { state.copy(loading = false, facts = emptyList(), error = throwable) }
    postSideEffect(FactSideEffect.Error(throwable))
  }
}
