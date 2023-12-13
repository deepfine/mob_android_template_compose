package com.deepfine.fact.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.deepfine.data.model.Fact

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
data class FactState(
  val loading: Boolean = false,
  val facts: List<Fact> = listOf(),
  val error: Throwable? = null
) {
  companion object {
    internal fun sequences() = sequenceOf(
      FactState(loading = true, facts = listOf(), error = null),
      FactState(
        loading = false,
        facts = listOf(
          Fact("Fact1", 1),
          Fact("Fact2", 2),
          Fact("Fact3", 3),
          Fact("Fact4", 4),
          Fact("Fact5", 5),
          Fact("Fact6", 6),
          Fact("Fact7", 7),
        ),
        error = null,
      ),
      FactState(
        loading = false,
        facts = listOf(),
        error = RuntimeException("Error Message"),
      ),
    )
  }
}

internal class FactScreenPreviewParameterProvider : PreviewParameterProvider<FactState> {
  override val values: Sequence<FactState>
    get() = FactState.sequences()
}
