package com.example.ui.presentetion.TabLayout

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ui.HealthFragment
import com.example.ui.presentetion.Navigator.BaseFragment

//Create a class extending from FragmentStateAdapter to swipe Fragments
class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

//    getItemCount(): This method returns the total number of items in the Adapter.

    override fun getItemCount(): Int {
        return 4

    }

    //    createFragment(position: Int): This method returns a Fragment instance for the given position.
    override fun createFragment(position: Int): BaseFragment {
        return when (position) {
            0 -> PhonesFragment()
            1 -> ComputerFragment()
            2 -> HealthFragment()
            else-> BooksFragment()
            
                
        }
    }
}