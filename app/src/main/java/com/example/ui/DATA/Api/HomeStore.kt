package com.example.ui.DATA.Api

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeStore(
    val id: Int? = null,
    @Json(name = "is_buy")
    val isBuy: Boolean? = null,
    @Json(name = "is_new" )
    val isNew: Boolean? = null,
    val picture: String? = null,
    val subtitle: String? = null,
    val title: String? = null
) : Parcelable