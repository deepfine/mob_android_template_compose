package com.deepfine.presentation.utils

import androidx.recyclerview.widget.DiffUtil

/**
 * @Description DiffCallback
 * @author yc.park (DEEP.FINE)
 * @since 2021-04-13
 * @version 1.0.0
 */
open class DiffCallback<T>(
  private val oldList: List<T>,
  private val newList: List<T>,
) : DiffUtil.Callback() {
  override fun getOldListSize() = oldList.size

  override fun getNewListSize() = newList.size

  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == newList[newItemPosition]

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = areItemsTheSame(oldItemPosition, newItemPosition)
}