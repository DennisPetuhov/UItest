package com.example.ui.presentetion.RecyclerAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ui.DATA.Api.BestSeller
import com.example.ui.DATA.Api.HomeStore
import com.example.ui.databinding.HorizontalRecyclerLayoutBinding

class HorizontalRecyclerAdapter : RecyclerView.Adapter<MyHomesViewHolder>() {
    var listOfPhones: MutableList<HomeStore> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomesViewHolder {
        val binding = HorizontalRecyclerLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyHomesViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MyHomesViewHolder, position: Int) {
        val phone = listOfPhones[position]
        holder.binding.apply {
            Glide.with(holder.itemView)
                .load(phone.picture)
                //   .centerCrop()
                .into(imageView3)
        }
    }

    override fun getItemCount(): Int {
        return listOfPhones.size
    }


    fun updateRecycler(list: MutableList<HomeStore>) {
        list.toMutableList()
        val diffcallback = Diffutill(listOfPhones, list)
        val differense = DiffUtil.calculateDiff(diffcallback, true)
        listOfPhones = list
        differense.dispatchUpdatesTo(this)


    }
}