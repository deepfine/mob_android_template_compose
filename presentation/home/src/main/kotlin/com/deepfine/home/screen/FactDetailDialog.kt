package com.deepfine.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.deepfine.domain.model.Fact
import com.deepfine.home.viewModel.FactDetailViewModel
import com.deepfine.presentation.ui.theme.ApplicationTheme

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Composable
internal fun FactDetailDialog(viewModel: FactDetailViewModel = hiltViewModel()) {
  FactDetailDialog(viewModel.fact)
}

@Composable
internal fun FactDetailDialog(fact: Fact) {
  ApplicationTheme {
    Surface(
      modifier = Modifier
        .fillMaxWidth(0.8F)
        .background(Color.White)
        .padding(20.dp),
    ) {
      Column {
        Text("Fact : ${fact.fact}")
        Text("Length : ${fact.length}", color = Color.Red)
      }
    }
  }
}

@Composable
@Preview
private fun FactDetailDialogPreview() {
  FactDetailDialog(
    Fact("Fact", 123),
  )
}
