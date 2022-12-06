package com.example.ui.presentetion.TabLayout

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui.R
import com.example.ui.presentetion.Navigator.BaseFragment

class ComputerFragment : BaseFragment()  {

    companion object {
        fun newInstance() = ComputerFragment()
    }

    private lateinit var viewModel: ComputerFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ComputerFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}