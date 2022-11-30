package com.example.ui.presentetion.RecyclerAdapter

import androidx.recyclerview.widget.DiffUtil

class DiffUtillVertical<out V>(private val oldList:List<V>, private val newList:List<V>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }
}