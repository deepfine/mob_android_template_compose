package com.deepfine.home.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.deepfine.domain.model.Fact
import com.deepfine.home.model.MainScreenPreviewParameterProvider
import com.deepfine.home.model.MainSideEffect
import com.deepfine.home.model.MainState
import com.deepfine.home.viewModel.MainViewModel
import com.deepfine.presentation.ui.theme.ApplicationTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

@Composable
internal fun MainScreen(navigateToFact: () -> Unit, viewModel: MainViewModel = hiltViewModel()) {
  val context = LocalContext.current
  viewModel.collectSideEffect(sideEffect = { handleSideEffects(context, it) })
  val state by viewModel.collectAsState()
  MainScreen(state = state, onRefreshClicked = viewModel::requestFacts, navigateToFact = navigateToFact)
}


private fun handleSideEffects(context: Context, sideEffect: MainSideEffect) {
  when (sideEffect) {
    is MainSideEffect.Error -> Toast.makeText(context, sideEffect.throwable.toString(), Toast.LENGTH_SHORT).show()
  }
}

@Composable
internal fun MainScreen(state: MainState, onRefreshClicked: () -> Unit = {}, navigateToFact: () -> Unit = {}) {
  ApplicationTheme {
    Surface(
      modifier = Modifier.fillMaxSize(),
      color = MaterialTheme.colorScheme.background,
    ) {

      Column {
        Row {
          Spacer(modifier = Modifier.width(5.dp))
          Button(
            onRefreshClicked,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color.Black),
            enabled = !state.loading,
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
              .height(48.dp),
          ) {
            Text("새로고침", color = Color.Black)
          }
        }

        Spacer(modifier = Modifier.height(10.dp))
        FactList(state.facts, navigateToFact)
      }

      Loading(state.loading)
      Error(state.error)
    }
  }
}

@Composable
internal fun FactList(facts: List<Fact>, navigateToFact: () -> Unit = {}) {
  LazyColumn(verticalArrangement = Arrangement.spacedBy(5.dp), modifier = Modifier.padding(horizontal = 5.dp)) {
    items(facts.size) { index ->
      FactItem(facts[index], navigateToFact)
    }
  }
}

@Composable
internal fun FactItem(fact: Fact, navigateToFact: () -> Unit = {}) {
  val context = LocalContext.current

  Card(
    colors = CardDefaults.cardColors(
      containerColor = Color.White,
    ),
    shape = RoundedCornerShape(8.dp),
    border = BorderStroke(1.dp, Color.Black),
    modifier = Modifier
      .fillMaxWidth()
      .background(color = Color.White)
      .clickable {
        navigateToFact()
        Toast
          .makeText(context, fact.fact, Toast.LENGTH_SHORT)
          .show()
      }
  ) {
    Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.padding(10.dp)) {
      Text("${fact.length} // ${fact.fact}")
    }
  }
}


@Composable
internal fun Loading(loading: Boolean) {
  if (loading)
    Box {
      CircularProgressIndicator(color = MaterialTheme.colorScheme.primary, modifier = Modifier.align(Alignment.Center))
    }
}


@Composable
internal fun Error(error: Throwable?) {
  if (error != null)
    Box {
      Text(text = error.message ?: "", color = Color.Red, modifier = Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
internal fun MainScreenPreview(@PreviewParameter(MainScreenPreviewParameterProvider::class) state: MainState) {
  MainScreen(state = state)
}