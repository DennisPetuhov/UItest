package com.example.ui.presentetion.RecyclerAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.ui.DATA.Api.BestSeller

class DiffUtillVertical(private val oldList:MutableList<BestSeller>, private val newList:MutableList<BestSeller>): DiffUtil.Callback() {
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