package com.deepfine.splash.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import com.deepfine.domain.model.Fact
import com.deepfine.presentation.ui.theme.ApplicationTheme
import com.deepfine.presentation.ui.theme.WindowAnimation
import com.deepfine.presentation.ui.theme.WindowTheme
import com.deepfine.splash.model.SplashSideEffect
import com.deepfine.splash.model.SplashState
import com.deepfine.splash.viewModel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-08-09
 * @version 1.0.0
 */
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
  private val viewModel: SplashViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      viewModel.collectSideEffect(sideEffect = ::handleSideEffects)

      WindowTheme(
        decorFitsSystemWindows = true,
        statusBarColor = Color.White,
        isAppearanceLightStatusBars = true,
        navigationBarColor = Color.White,
        isAppearanceLightNavigationBars = true,
        windowAnimation = WindowAnimation.POP_UP
      )

      ApplicationTheme {
        val state by viewModel.collectAsState()

        SplashScreen(
          state = state,
          onRefreshClicked = viewModel::requestFacts
        )
      }
    }
  }

  private fun handleSideEffects(sideEffect: SplashSideEffect) {
    when (sideEffect) {
      is SplashSideEffect.Error -> Toast.makeText(this, sideEffect.throwable.toString(), Toast.LENGTH_SHORT).show()
    }
  }
}

@Composable
fun SplashScreen(state: SplashState, onRefreshClicked: () -> Unit = {}) {
  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {


    Column {
      Row {
        Spacer(modifier = Modifier.width(5.dp))
        Button(onRefreshClicked, enabled = !state.loading) {
          Text("새로고침")
        }
      }


      LazyColumn(verticalArrangement = Arrangement.spacedBy(5.dp), modifier = Modifier.padding(horizontal = 5.dp)) {
        items(state.facts.size) { index ->
          FactItem(state.facts[index])
        }
      }
    }

    Loading(state.loading)
  }
}

@Composable
fun FactItem(fact: Fact) {
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
fun Loading(loading: Boolean) {
  if (loading)
    Box {
      CircularProgressIndicator(Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
  SplashScreen(
    state = SplashState(
      loading = false, facts = listOf(
        Fact("Fact1", 1),
        Fact("Fact2", 2),
        Fact("Fact3", 3),
        Fact("Fact4", 4),
        Fact("Fact5", 5),
        Fact("Fact6", 6),
        Fact("Fact7", 7),
      ), error = null
    ),
  )
}

@Preview
@Composable
fun FactItemPreview() {
  ApplicationTheme {
    FactItem(
      Fact(fact = "fact", length = 1)
    )
  }
}