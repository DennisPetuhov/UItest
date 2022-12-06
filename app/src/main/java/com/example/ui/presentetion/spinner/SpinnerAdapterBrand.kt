package com.example.ui.presentetion.spinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ui.R

class SpinnerAdapterBrand(val context: Context, val list:Array<String>): BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        return 0
    }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val view:View
            if (convertView==null){
                view= LayoutInflater.from(context).inflate(R.layout.spinner_item_bottom_sheet,parent,false)
                val textView: TextView = view.findViewById(R.id.text_bottom_sheet_spinner)
                val arrow =view.findViewById<ImageView>(R.id.imageArrow)
                textView.text=list[position]
            } else{
                view=convertView
            }
            return view
        }


    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (position == 0) {
            view = getView(position, convertView, parent)
            val iconArrow = view.findViewById(R.id.imageArrow) as ImageView
            iconArrow.setImageResource(R.drawable.arrow_down)
            iconArrow.animate()
                .rotation(180f)
                .setDuration(200)
                .start()

        } else {
            view = getView(position, convertView, parent)
            val iconArrow = view.findViewById(R.id.imageArrow) as ImageView
            iconArrow.setImageResource(R.color.white)


        }
        return view

    }
    }
