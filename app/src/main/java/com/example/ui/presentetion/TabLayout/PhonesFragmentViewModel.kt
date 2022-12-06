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
//val flow: StateFlow<StatusModel<List<HomeStore>>> get() = mutableFlow
//   private var mutableFlow = MutableStateFlow(
//        StatusModel(
//            Status.LOADING, "",listOf(HomeStore() )
//        )
//    )

//    init {
//        getPhones()
//    }


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


//    fun search( listOfPhones: List<BestSeller>?,text: String): ArrayList<BestSeller>? {
//    // creating a new array list to filter our data.
//    var filteredlist: ArrayList<BestSeller> = ArrayList()
//
//    // running a for loop to compare elements.
//    if (listOfPhones != null) {
//        for (item in listOfPhones) {
//            // checking if the entered string matched with any item of our recycler view.
//            if (item.title!=null)
//                if(item.title.lowercase().contains(text.lowercase())) {
//                    // if the item is matched we are
//                    // adding it to our filtered list.
//                    filteredlist.add(item)
//                }
//        }
//    }
//    if (filteredlist.isEmpty()) {
//
//        // if no item is added in filtered list we are
//        // displaying a toast message as no data found.
////            Toast.makeText(this@Fragment1, "No Data Found..", Toast.LENGTH_SHORT).show()
//
//    } else {
//        // at last we are passing that filtered
//        // list to our adapter class.
////            courseRVAdapter.filterList(filteredlist)
//    }
//         viewModelScope.launch {
//             StatusModel.sucsess(filteredlist)  }
//
//    return filteredlist
//}
//


    suspend fun fillter(pair: Pair<Int, Int>) {
        mutableFlowInner.value.data!!.bestSeller!!.filter { pair.first <= it.discountPrice!! && it.discountPrice <= pair.second }
    }

//    fun filter1(pair: Pair<Int, Int>): MutableStateFlow<StatusModel<StoreResponse>> {
//
//        val list =  mutableFlowInner.value.data!!.bestSeller!!
//        val listNew = ArrayList<BestSeller>()
//
//        for (it in list){
//            if (pair.first <= it.discountPrice!! && it.discountPrice <= pair.second ){
//                listNew.add(it)
//              val newL=  listNew.toMutableList()
//            }
//        }
//
//
//
//    }



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



//
//    fun getFilterPrice(pair: Pair<Int, Int>) {
//        viewModelScope.launch {
//            val a = mutableFlowInner.value.data?.bestSeller?.filter {
//                pair.first <= it.discountPrice!! && it.discountPrice <= pair.second
//
//            }

//            mutableFlow.value.data?.bestSeller=a
            println("*** $a")
//           mutableFlow.value.data?.bestSeller=a
            flowOuter.value.data?.bestSeller = a


        }

    }


}


