package com.example.ui.DATA.Api

import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiHelper {
    fun getInstanceOfRetrofit():ApiService{
        val gson = GsonBuilder().create()
        val moshi =Moshi.Builder().add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Companion.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val api: ApiService = retrofit.create(ApiService::class.java)

        return api

    }

    companion object {
        private const val BASE_URL = "https://run.mocky.io/v3/"
    }
}