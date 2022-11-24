package com.example.ui.presentetion.TabLayout

import com.example.ui.R

class TabObjectData {
    companion object{
        val tabList:List<TabObject> = listOf(
            TabObject(
                "Phones",
                R.drawable.vector_phone,
                1
            ),
            TabObject(
                "Computer",
                R.drawable.vector_computer,
                2
            ),
            TabObject(
                "Health",
                R.drawable.vector_hear,
                3
            ),
            TabObject(
                "Books",
                R.drawable.vector_books,
                4
            )
        )
    }
}