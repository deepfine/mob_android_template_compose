package com.deepfine.presentation.ui.extensions

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavBackStackEntry
import java.io.Serializable

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

fun <T : Parcelable> Bundle.parseParcelable(key: String, clazz: Class<T>): T =
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    getParcelable(key, clazz)!!
  } else {
    @Suppress("DEPRECATION")
    getParcelable(key)!!
  }

fun <T : Serializable> Bundle.parseSerializable(key: String, clazz: Class<T>): T =
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
    getSerializable(key, clazz)!!
  } else {
    @Suppress("UNCHECKED_CAST", "DEPRECATION")
    getSerializable(key) as T
  }

fun NavBackStackEntry.requireArgument() = arguments!!