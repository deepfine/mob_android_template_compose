package com.deepfine.home.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.deepfine.domain.model.Fact

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
data class MainState(
  val loading: Boolean = false,
  val facts: List<Fact> = listOf(),
  val error: Throwable? = null,
) {
  companion object {
    internal fun sequences() = sequenceOf(
      MainState(loading = true, facts = listOf(), error = null),
      MainState(
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
      MainState(
        loading = false,
        facts = listOf(),
        error = RuntimeException("Error Message"),
      ),
    )
  }
}

internal class MainScreenPreviewParameterProvider : PreviewParameterProvider<MainState> {
  override val values: Sequence<MainState>
    get() = MainState.sequences()
}
