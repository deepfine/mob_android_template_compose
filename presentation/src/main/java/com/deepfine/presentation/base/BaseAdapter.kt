package com.deepfine.presentation.base

import com.deepfine.presentation.extensions.setOnDebounceClickListener
import com.deepfine.presentation.utils.DiffCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * @Description Class
 * @author jh.kim (DEEP.FINE)
 * @since 2/1/21
 * @version 1.0.0
 */
abstract class BaseAdapter<T, H : RecyclerView.ViewHolder> :
  RecyclerView.Adapter<H>() {

  var onItemClickListener: OnItemClickListener<T>? = null
  protected var itemList: MutableList<T>? = null

  override fun getItemCount(): Int = itemList?.size ?: 0

  open fun updateItems(items: List<T>, diffCallback: DiffCallback<*> = DiffCallback(itemList ?: listOf(), items)) {
    val diffResult = DiffUtil.calculateDiff(diffCallback)
    itemList = items.toMutableList()
    diffResult.dispatchUpdatesTo(this)
  }

  override fun onBindViewHolder(holder: H, position: Int) {
    holder.itemView.setOnDebounceClickListener(action = {
      try {
        itemList?.get(holder.adapterPosition)?.let {
          onItemClickListener?.onItemClick(it)
        }
      } catch (_: Exception) {
      }
    })
  }

  fun interface OnItemClickListener<T> {
    fun onItemClick(item: T)
  }
}