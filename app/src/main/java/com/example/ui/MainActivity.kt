package com.example.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ui.databinding.ActivityMainBinding
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
        initSpinner(        )
//        val navHost =
//            supportFragmentManager.findFragmentById(androidx.navigation.fragment.R.id.nav_host_fragment_container) as NavHostFragment
//        navController = navHost.navController
    }

    private fun initSpinner() {
        val cityList=resources.getStringArray(R.array.locations)
        val spinner=findViewById<Spinner>(R.id.spinner)
        spinner.adapter= SpinnerAdapter(this@MainActivity,cityList)
    }

    private fun initPager(list: List<TabObject>) {
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val myViewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = myViewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tabLayoutTab, position ->
            val myView = layoutInflater.inflate(R.layout.tab_item_layout, null, false)
            myView.findViewById<ImageView>(R.id.image_directory)
                .setImageResource(list[position].pic)
            myView.findViewById<TextView>(R.id.textView).text = list[position].text
            tabLayoutTab.apply {
                customView = myView
                if (position == 0) {
                    customView?.apply {
                        findViewById<ImageView>(R.id.circle).setColorFilter(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.orange
                            )


                        )
                        findViewById<TextView>(R.id.textView).setTextColor(Color.parseColor("#FF6E4E"))
                        findViewById<ImageView>(R.id.image_directory).setColorFilter(
                            ContextCompat.getColor(
                                this@MainActivity,
                                R.color.white
                            )
                        )

                    }
                }
            }

        }.attach()
        binding.viewPager.isUserInputEnabled = false // выключение скрола свайпом

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.apply {
                    findViewById<ImageView>(R.id.circle).setColorFilter(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.orange
                        )


                    )
                    findViewById<TextView>(R.id.textView).setTextColor(Color.parseColor("#FF6E4E"))
                    findViewById<ImageView>(R.id.image_directory).setColorFilter(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.white
                        )
                    )

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.apply {
                    findViewById<ImageView>(R.id.circle).setColorFilter(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.white
                        )


                    )
                    findViewById<TextView>(R.id.textView).setTextColor(Color.parseColor("#B3B3C3"))
                    findViewById<ImageView>(R.id.image_directory).setColorFilter(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.tab_layout_icon_color
                        )
                    )

                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}