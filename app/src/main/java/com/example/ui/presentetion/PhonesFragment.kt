package com.example.ui.presentetion

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.ui.DATA.Api.Status
import com.example.ui.R
import com.example.ui.presentetion.Navigator.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
        toRecycler()
        // TODO: Use the ViewModel
    }

    fun toRecycler(){
        println("FUN toRecycler() started")
        viewLifecycleOwner.lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getMovies()
                viewModel.flow.collect{
                    when(it.status){
                        Status.ERROR -> {
                            println(it.message)
                        }
                        Status.SUCCESS -> {
                            it.data?.let { it1 ->
                                println(it.data.bestSeller.toString())
                                println("success")
                            }
                        }
                        Status.LOADING -> {
                            println(it.data)
                        }

                    }
                }
            }
        }

    }

}