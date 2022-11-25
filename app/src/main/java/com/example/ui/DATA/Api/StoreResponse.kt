package com.example.ui.DATA.Api

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize

data class StoreResponse(
    @Json(name ="best_seller")
    val besSeller: List<BestSeller>?,
    @Json(name ="home_store")
    val home_store: List<HomeStore>?
):Parcelable