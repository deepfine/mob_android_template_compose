package com.deepfine.presentation.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.delay

/**
 * @Description Class
 * @author yc.park (DEEP.FINE)
 * @since 2021-12-14
 * @version 1.0.0
 */

fun View.setOnDebounceClickListener(action: suspend () -> Unit) {
  val event = CoroutineScope(Dispatchers.Default).actor<Unit>(Dispatchers.Main) {
    for (event in channel) {
      action()
      delay(300)
    }
  }
  setOnClickListener {
    event.trySend(Unit)
  }
}

fun View.showKeyboard() {
  val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
  this.requestFocus()
  imm.showSoftInput(this, 0)
}

fun View.hideKeyboard() {
  val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
  imm.hideSoftInputFromWindow(windowToken, 0)
}