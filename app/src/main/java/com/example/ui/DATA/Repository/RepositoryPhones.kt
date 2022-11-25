package com.example.ui.DATA.Repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.ui.DATA.Api.ApiService
import com.example.ui.DATA.Api.HomeStore
import com.example.ui.DATA.Api.StatusModel
import com.example.ui.DATA.Api.StoreResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RepositoryPhones(val apiService: ApiService) {
    suspend fun getPhones(): Flow<StatusModel<StoreResponse>> {
        return flow {
            val response = apiService.getPhonesResponse()
            Log.d("*response", response.toString())
            val responseHomeStore = response.homeStore
            Log.d("*responseHomeStore", responseHomeStore.toString())
            val responseBestseller = response.bestSeller
            Log.d("*responseBestseller", responseBestseller.toString())
            emit(StatusModel.sucsess(StoreResponse(responseBestseller, responseHomeStore)))
        }.flowOn(Dispatchers.IO)

    }
}