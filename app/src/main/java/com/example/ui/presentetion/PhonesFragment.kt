package com.example.ui.presentetion

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui.DATA.Api.Status
import com.example.ui.R
import com.example.ui.databinding.FragmentPhonesBinding
import com.example.ui.presentetion.Navigator.BaseFragment
import com.example.ui.presentetion.RecyclerAdapter.HorizontalRecyclerAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PhonesFragment : BaseFragment()  {
    lateinit var binding: FragmentPhonesBinding
    val adapter= HorizontalRecyclerAdapter()

    companion object {
        fun newInstance() = PhonesFragment()
    }

    private lateinit var viewModel: PhonesFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PhonesFragmentViewModel::class.java)
        toRecycler()
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
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
                            it.data?.let {
                                it.homeStore?.let { it1 -> adapter.updateRecycler(it1.toMutableList()) }
//                                println(it1.bestSeller.toString())
//                                println("success")
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



    fun initRecycler() {


        binding.horizontalRecycler.adapter = adapter
        binding.horizontalRecycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

    }
}