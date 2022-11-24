package com.example.ui.presentetion

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui.R
import com.example.ui.presentetion.Navigator.BaseFragment

class PhonesFragment : BaseFragment()  {

    companion object {
        fun newInstance() = PhonesFragment()
    }

    private lateinit var viewModel: PhonesFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_phones, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PhonesFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}