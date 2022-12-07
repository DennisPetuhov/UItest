package com.example.ui

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.ui.databinding.ActivityMainBinding
import com.example.ui.presentetion.BottomSheet.BottomSheetDialogFragment

import com.example.ui.presentetion.TabLayout.TabObject
import com.example.ui.presentetion.TabLayout.TabObjectData
import com.example.ui.presentetion.TabLayout.ViewPagerAdapter
import com.example.ui.presentetion.spinner.SpinnerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

val listOfTabs: List<TabObject> = TabObjectData.tabList

class MainActivity : AppCompatActivity() {
    //    lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        initPager(listOfTabs)

//        bottomNavigation()


        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHost.navController
//        navController.navigate(R.id.action_phonesFragment_to_deteailsFragment)

//        val navHost =
//            supportFragmentManager.findFragmentById(androidx.navigation.fragment.R.id.nav_host_fragment_container) as NavHostFragment
//        navController = navHost.navController
    }


    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)

//        initSpinner()
//        bottomSheet()
    }
    override fun onBackPressed() {
        if (binding.viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            binding.viewPager.currentItem = binding.viewPager.currentItem - 1
        }
    }

    fun bottomSheet() {
        binding.button1.setOnClickListener {
            val bottomSheet = BottomSheetDialogFragment()
            bottomSheet.show(
                getSupportFragmentManager(),
                "ModalBottomSheet"
            )

        }
    }

    fun bottomNavigation() {

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)
    }

//    private fun initSpinner() {
//        val cityList = resources.getStringArray(R.array.locations)
//        val spinner = findViewById<Spinner>(R.id.spinner)
//        spinner.adapter = SpinnerAdapter(this@MainActivity, cityList)
//    }

    private fun initPager(list: List<TabObject>) {
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
//        tabLayout.setupWithViewPager(viewPager,false)
        val myViewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = myViewPagerAdapter
//        TabLayoutMediator(tabLayout, viewPager, false) { tabLayoutTab, position ->
//            val myView = layoutInflater.inflate(R.layout.tab_item_layout, null, false)
//            myView.findViewById<ImageView>(R.id.image_directory)
//                .setImageResource(list[position].pic)
//            myView.findViewById<TextView>(R.id.textView).text = list[position].text
//            tabLayoutTab.apply {
//                customView = myView
//                if (position == 0) {
//                    customView?.apply {
//                        findViewById<ImageView>(R.id.circle).setColorFilter(
//                            ContextCompat.getColor(
//                                this@MainActivity,
//                                R.color.orange
//                            )
//
//
//                        )
//                        findViewById<TextView>(R.id.textView).setTextColor(Color.parseColor("#FF6E4E"))
//                        findViewById<ImageView>(R.id.image_directory).setColorFilter(
//                            ContextCompat.getColor(
//                                this@MainActivity,
//                                R.color.white
//                            )
//                        )
//
//                    }
//                }
//            }
//
//        }.attach()
//        binding.viewPager.isUserInputEnabled = false // выключение скрола свайпом
//
//        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                tab?.customView?.apply {
//                    findViewById<ImageView>(R.id.circle).setColorFilter(
//                        ContextCompat.getColor(
//                            this@MainActivity,
//                            R.color.orange
//                        )
//
//
//                    )
//                    findViewById<TextView>(R.id.textView).setTextColor(Color.parseColor("#FF6E4E"))
//                    findViewById<ImageView>(R.id.image_directory).setColorFilter(
//                        ContextCompat.getColor(
//                            this@MainActivity,
//                            R.color.white
//                        )
//                    )
//
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                tab?.customView?.apply {
//                    findViewById<ImageView>(R.id.circle).setColorFilter(
//                        ContextCompat.getColor(
//                            this@MainActivity,
//                            R.color.white
//                        )
//
//
//                    )
//                    findViewById<TextView>(R.id.textView).setTextColor(Color.parseColor("#B3B3C3"))
//                    findViewById<ImageView>(R.id.image_directory).setColorFilter(
//                        ContextCompat.getColor(
//                            this@MainActivity,
//                            R.color.tab_layout_icon_color
//                        )
//                    )
//
//                }
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//
//            }
//        })
//        binding.viewPager.isUserInputEnabled = false // выключение скрола свайпом
    }

}