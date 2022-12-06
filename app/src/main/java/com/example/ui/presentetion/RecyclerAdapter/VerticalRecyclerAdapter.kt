package com.example.ui.presentetion.RecyclerAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ui.DATA.Api.BestSeller
import com.example.ui.R
import com.example.ui.databinding.VerticalRecyclerLayoutBinding
import java.text.DecimalFormat


class VerticalRecyclerAdapter : RecyclerView.Adapter<ViewHolderVertical>() {

    var listOfPhones: MutableList<BestSeller> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderVertical {
        val binding = VerticalRecyclerLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolderVertical(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderVertical, position: Int) {
        val phone = listOfPhones[position]
        holder.binding.apply {
            Glide.with(holder.itemView)
                .load(phone.picture)
                //   .centerCrop()
                .into(imageView)
            samsungGal.text = phone.title
            if (phone.isFavorites == true) {
               heartSmall.setImageResource(R.drawable.vectorheart_small_orange)
            } else {
                heartSmall.setImageResource(R.drawable.vectorheart_small_white)
            }
            val formatOfPrice = DecimalFormat("#,###.##")
           val newDiscount= formatOfPrice.format(phone.discountPrice)
            price.text="$${formatOfPrice.format(phone.priceWithoutDiscount)}"
            discountPrice.text="$${formatOfPrice.format(phone.discountPrice)}"


        }
        holder.itemView.setOnClickListener{


            holder.binding.phoneHolder.findNavController().navigate(R.id.action_phonesFragment_to_deteailsFragment,null)
        }

    }

    override fun getItemCount(): Int {
        return listOfPhones.size
    }

    fun updateRecycler(list: MutableList<BestSeller>) {
        list.toMutableList()
        val diffcallback = Diffutill(listOfPhones, list)
        val differense = DiffUtil.calculateDiff(diffcallback, true)
        listOfPhones = list
        differense.dispatchUpdatesTo(this)


    }
}