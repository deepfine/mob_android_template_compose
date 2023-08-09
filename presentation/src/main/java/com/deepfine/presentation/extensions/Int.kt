package com.deepfine.presentation.extensions

import com.deepfine.presentation.R
import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import java.text.DecimalFormat

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-02-20
 * @version 1.0.0
 */

val Int.dp: Int
  get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Int.dpToPx: Int
  get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), Resources.getSystem().displayMetrics).toInt()