package com.example.ui.DATA.Api

import retrofit2.http.GET


interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getPhonesResponse(): PhonesDto

}