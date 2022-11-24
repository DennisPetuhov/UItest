package com.example.ui.DATA.Api

data class StoreResponse(
    val best_seller: List<BestSellerX>,
    val home_store: List<HomeStoreX>
)