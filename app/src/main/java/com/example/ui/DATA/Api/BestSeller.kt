package com.example.ui.DATA.Api

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class BestSeller(
    @Json(name ="discount_price" )
    val discountPrice: Int?=null,
    val id: Int?=null,
    @Json(name = "is_favorites")
    val isFavorites: Boolean?=null,
    val picture: String?=null,
    @Json(name = "price_without_discount" )
    val priceWithoutDiscount: Int?=null,
    val title: String?=null
):Parcelable