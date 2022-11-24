package com.example.ui.DATA.Api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiHelper {
    private const val BASE_URL = "https://run.mocky.io/v3/"
    fun api():ApiService{
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val api: ApiService = retrofit.create(ApiService::class.java)

        return api

    }
}