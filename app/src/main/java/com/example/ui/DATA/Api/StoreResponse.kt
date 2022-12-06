package com.example.ui.DATA.Api

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize

data class StoreResponse(
    @Json(name ="best_seller")
    var bestSeller: List<BestSeller>?,
    @Json(name ="home_store")
    val homeStore: List<HomeStore>?
):Parcelable