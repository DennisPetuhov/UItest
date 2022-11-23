package com.example.ui.presentetion.Navigator
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch

open class BaseFragment : Fragment() {

    fun handleNAvigation(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is NavigationCommand.Back -> {
                findNavController().navigateUp()
            }
            is NavigationCommand.Null -> {
                null
            }
            is NavigationCommand.ToDirection -> {
                findNavController().navigate(navigationCommand.direction)
            }
        }

    }


    fun observeNavigation(viewModel: BaseViewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(
                Lifecycle.State.STARTED

            ) {
                viewModel.navigation.collect {
                    handleNAvigation(it)
                }


            }
        }

    }

}