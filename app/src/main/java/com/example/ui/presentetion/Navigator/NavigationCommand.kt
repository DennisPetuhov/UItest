package com.example.ui.presentetion.Navigator

import androidx.navigation.NavDirections

sealed class NavigationCommand {
    class ToDirection(val direction: NavDirections) : NavigationCommand()
    object Back : NavigationCommand()
    object Null : NavigationCommand()
}