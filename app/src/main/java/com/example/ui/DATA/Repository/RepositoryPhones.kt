package com.example.ui.DATA.Repository

import com.example.ui.DATA.Api.ApiService
import com.example.ui.DATA.Api.StatusModel
import com.example.ui.DATA.Api.StoreResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

class RepositoryPhones(val apiService: ApiService) {
   suspend fun getPhones(): Flow<StatusModel<StoreResponse>> {
       return flow {
           val response=apiService.getPhonesResponse()
           emit(StatusModel.sucsess(response))
       }.flowOn(Dispatchers.IO)

   }
}