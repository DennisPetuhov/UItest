package com.example.ui.presentetion.Navigator

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseViewModel : ViewModel() {
    private val _navigation: MutableStateFlow<NavigationCommand> =
        MutableStateFlow(NavigationCommand.Null)
    val navigation: StateFlow<NavigationCommand> get() = _navigation

    fun getNavigation(navDirections: NavDirections) {
        _navigation.value = NavigationCommand.ToDirection(navDirections)

    }
    fun getBack(){
        _navigation.value=NavigationCommand.Back
    }
}