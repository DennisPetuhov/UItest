package com.example.ui.presentetion

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui.R
import com.example.ui.presentetion.Navigator.BaseFragment

class DeteailsFragment : BaseFragment() {

    companion object {
        fun newInstance() = DeteailsFragment()
    }

    private lateinit var viewModel: DeteailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_deteails, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DeteailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}