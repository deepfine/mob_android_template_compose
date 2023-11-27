package com.deepfine.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
private fun FactDetailDialog(fact: Fact) {
  ApplicationTheme {
    Box(
      modifier = Modifier
        .fillMaxWidth(0.8F)
        .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
        .background(Color.White, RoundedCornerShape(10.dp))
        .padding(10.dp),
    ) {
      Column {
        Text(
          fact.toString(),
        )
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
