package com.example.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ui.databinding.ActivityMainBinding
import com.example.ui.presentetion.TabLayout.TabObject
import com.example.ui.presentetion.TabLayout.TabObjectData
import com.example.ui.presentetion.TabLayout.ViewPagerAdapter
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
//        val navHost =
//            supportFragmentManager.findFragmentById(androidx.navigation.fragment.R.id.nav_host_fragment_container) as NavHostFragment
//        navController = navHost.navController
    }

    private fun initPager(list: List<TabObject>) {
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val myViewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = myViewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tabLayoutTab, position ->
            val myView = layoutInflater.inflate(R.layout.tab_item_layout,null,false)
            myView.findViewById<ImageView>(R.id.image_directory).setImageResource(list[position].pic)
            myView.findViewById<TextView>(R.id.textView).text= list[position].text
            tabLayoutTab.apply {
                customView=myView
                if (position==0){
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
    }
}