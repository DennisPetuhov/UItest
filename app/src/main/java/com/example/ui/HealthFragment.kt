package com.example.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui.presentetion.Navigator.BaseFragment

class HealthFragment : BaseFragment()  {

    companion object {
        fun newInstance() = HealthFragment()
    }

    private lateinit var viewModel: HealthFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HealthFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}