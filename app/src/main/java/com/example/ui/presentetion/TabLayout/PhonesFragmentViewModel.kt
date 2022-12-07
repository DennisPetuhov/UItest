package com.example.ui.presentetion.TabLayout


import androidx.lifecycle.viewModelScope
import com.example.ui.DATA.Api.*
import com.example.ui.DATA.Repository.RepositoryPhones

import com.example.ui.presentetion.Navigator.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

import kotlinx.coroutines.launch


class PhonesFragmentViewModel : BaseViewModel() {
    val api = ApiHelper().getInstanceOfRetrofit()
    val repo = RepositoryPhones(api)

    val flowOuter: StateFlow<StatusModel<StoreResponse>> get() = mutableFlowInner


    var mutableFlowInner = MutableStateFlow(
        StatusModel(
            Status.LOADING, "", StoreResponse(listOf(BestSeller()), listOf(HomeStore()))
        )
    )



    fun getPhones() {
        mutableFlowInner.value = StatusModel.loading()
        viewModelScope.launch(Dispatchers.IO) {
            repo.getPhones().catch {
                mutableFlowInner.value = StatusModel.error(it.message.toString())

            }.collect {
                it?.let {
                    mutableFlowInner.value = StatusModel.sucsess(it.data)
                }
            }


        }
    }

    fun search1(listOfPhones: List<BestSeller>?, newText: String): List<BestSeller>? {
        return listOfPhones?.filter {
            it.title!!.lowercase()?.contains(newText.lowercase())!!
        }

    }

    fun getFilterPrice(pair: Pair<Int, Int>) {
        viewModelScope.launch {

        val a=    mutableFlowInner.value.data?.bestSeller?.filter {
                pair.first <= it.discountPrice!! && it.discountPrice <= pair.second

            }
            mutableFlowInner.emit(StatusModel.sucsess(
                StoreResponse(a,
                    mutableFlowInner.value.data?.homeStore
                )
            ))



            println("*** $a")

            flowOuter.value.data?.bestSeller = a


        }

    }


}


