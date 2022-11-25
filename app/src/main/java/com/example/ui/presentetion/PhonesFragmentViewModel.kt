package com.example.ui.presentetion


import androidx.lifecycle.viewModelScope
import com.example.ui.DATA.Api.*
import com.example.ui.DATA.Repository.RepositoryPhones

import com.example.ui.presentetion.Navigator.BaseViewModel
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class PhonesFragmentViewModel : BaseViewModel() {
    val api = ApiHelper().getInstanceOfRetrofit()
    val repo = RepositoryPhones(api)
//    val flow: StateFlow<StatusModel<StoreResponse>> get() = mutableFlow


//
//    var mutableFlow = MutableStateFlow(
//        StatusModel(
//            Status.LOADING, "", StoreResponse(listOf(), listOf())
//        )
//    )
val flow: StateFlow<StatusModel<List<HomeStore>>> get() = mutableFlow
   private var mutableFlow = MutableStateFlow(
        StatusModel(
            Status.LOADING, "",listOf(HomeStore() )
        )
    )

    fun getMovies() {
        mutableFlow.value = StatusModel.loading()
        viewModelScope.launch(Dispatchers.IO) {
            repo.getPhones().catch {
                mutableFlow.value = StatusModel.error(it.message.toString())

            }.collect {
                it?.let {
                    mutableFlow.value = StatusModel.sucsess(it.data)
                }
            }


        }
    }

}
