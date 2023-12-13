package com.deepfine.fact.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.deepfine.data.model.Fact
import com.deepfine.fact.viewModel.FactDetailViewModel
import com.deepfine.presentation.ui.theme.ApplicationTheme

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
@Composable
fun FactDetailDialog(viewModel: FactDetailViewModel = hiltViewModel(), onCloseClicked: () -> Unit) {
  FactDetailDialog(viewModel.fact, onCloseClicked)
}

@Composable
private fun FactDetailDialog(fact: Fact, onCloseClicked: () -> Unit = {}) {
  ApplicationTheme {
    Column(
      modifier = Modifier
        .fillMaxWidth(0.8f)
        .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
        .background(Color.White, RoundedCornerShape(10.dp))
        .padding(10.dp),
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Text(
          fact.length.toString(),
          fontWeight = FontWeight.Bold,
        )

        IconButton(
          modifier = Modifier
            .size(20.dp),
          onClick = onCloseClicked,
        ) {
          Icon(
            imageVector = Icons.Filled.Close,
            tint = Color.Black,
            contentDescription = null,
          )
        }
      }
      Text(fact.fact)
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
