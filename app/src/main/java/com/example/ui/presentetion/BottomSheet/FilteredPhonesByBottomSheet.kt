package com.example.ui.presentetion.BottomSheet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilteredPhonesByBottomSheet(
    var name:String?,
    var price:Pair<Int,Int>?
) :Parcelable