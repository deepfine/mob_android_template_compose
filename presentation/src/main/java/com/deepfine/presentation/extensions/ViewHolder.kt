package com.deepfine.presentation.extensions

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 * @since 2023-04-12
 * @version 1.0.0
 */

fun ViewHolder.getString(@StringRes resId: Int) =
  itemView.context.getString(resId)

fun ViewHolder.getDrawable(@DrawableRes resId: Int) =
  ContextCompat.getDrawable(itemView.context, resId)

fun ViewHolder.getColor(@ColorRes resId: Int) =
  ContextCompat.getColor(itemView.context, resId)