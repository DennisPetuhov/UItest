package com.example.ui.presentetion.RecyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
            titlePhone.text=phone.title
            sPerMega.text=phone.subtitle

            Glide.with(holder.itemView)
                .load(phone.picture)
                //   .centerCrop()
                .into(imageView3)

            if (phone.isNew == true) {
                newIconImage.visibility = View.VISIBLE
                newIconText.visibility = View.VISIBLE
            } else {
                newIconImage.visibility = View.INVISIBLE
                newIconText.visibility = View.INVISIBLE

            }

            if (phone.isBuy == true) {
                rectangle8.visibility = View.VISIBLE
            } else { rectangle8.visibility = View.INVISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return listOfPhones.size
    }


    fun updateRecyclerHorizontal(list: MutableList<HomeStore>) {
        list.toMutableList()
        val diffcallback = DiffUtiLLHorizontal(listOfPhones, list)
        val differense = DiffUtil.calculateDiff(diffcallback, true)
        listOfPhones = list
        differense.dispatchUpdatesTo(this)


    }
}