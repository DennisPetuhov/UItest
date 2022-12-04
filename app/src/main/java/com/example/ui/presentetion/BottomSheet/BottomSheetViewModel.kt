package com.example.ui.presentetion.BottomSheet

import androidx.lifecycle.viewModelScope
import com.example.ui.presentetion.Navigator.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BottomSheetViewModel : BaseViewModel() {
    val filter: StateFlow<FilteredPhonesByBottomSheet> get() = _filter
    private val _filter: MutableStateFlow<FilteredPhonesByBottomSheet> =
        MutableStateFlow(FilteredPhonesByBottomSheet(null, null))


    fun getFilterPrice(pair: Pair<Int,Int>){
        viewModelScope.launch {
            _filter.value.price =pair
        }
    }
    fun getFilterName(name: String){
        viewModelScope.launch {
            _filter.value.name =name
        }
    }

}