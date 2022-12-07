package com.example.ui.presentetion.RecyclerAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.ui.DATA.Api.HomeStore

class DiffUtiLLHorizontal(private val oldList:MutableList<HomeStore>, private val newList:MutableList<HomeStore>):DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id==newList[newItemPosition].id

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }
}