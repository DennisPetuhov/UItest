package com.example.ui.presentetion.TabLayout

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui.DATA.Api.Status
import com.example.ui.databinding.FragmentPhonesBinding
import com.example.ui.presentetion.Navigator.BaseFragment
import com.example.ui.presentetion.RecyclerAdapter.HorizontalRecyclerAdapter
import com.example.ui.presentetion.RecyclerAdapter.VerticalRecyclerAdapter
import kotlinx.coroutines.launch

class PhonesFragment : BaseFragment() {
    lateinit var binding: FragmentPhonesBinding
    val adapterHorizontal = HorizontalRecyclerAdapter()
    val adapterVertical = VerticalRecyclerAdapter()

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
        viewModel = ViewModelProvider(requireActivity()).get(PhonesFragmentViewModel::class.java)
        toRecycler()
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        search()
    }


    fun toRecycler() {
        println("FUN toRecycler() started")
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getPhones()
                viewModel.flowOuter.collect {
                    when (it.status) {
                        Status.ERROR -> {
                            println(it.message)
                        }
                        Status.SUCCESS -> {
                            it.data?.let {
                                it.homeStore?.let { it1 -> adapterHorizontal.updateRecycler(it1.toMutableList()) }
                                it.bestSeller?.let { it1 -> adapterVertical.updateRecycler(it1.toMutableList()) }
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
//        val search=binding.searchBar
//        if (search !=null){
//            val mySearch = search as SearchView
//            mySearch.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
//                override fun onQueryTextSubmit(query: String?): Boolean {
//                    return true
//                }
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//                    if (newText!!.isNotEmpty()){
//                        viewLifecycleOwner.lifecycleScope.launch {
//                            repeatOnLifecycle(Lifecycle.State.STARTED){
//                                viewModel.flow.collect{
//                                    it.data?.bestSeller.let {
//                                        val list = viewModel.search(it,newText)
//                                        if (list != null) {
//                                            adapterVertical.updateRecycler(list.toMutableList())
//                                        }
//                                    }
//
//                                }
//                            }
//                        }
//
//
//                    }
//                    return true
//                }
//            })
//        }


    }


    fun initRecycler() {


        binding.horizontalRecycler.adapter = adapterHorizontal
        binding.horizontalRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.verticalRecycler.adapter = adapterVertical
        binding.verticalRecycler.layoutManager = GridLayoutManager(requireContext(), 2)

    }


    //    fun search() {
//        val search = binding.searchBar
//        if (search != null) {
//            val mySearch = search as SearchView
//            mySearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//                override fun onQueryTextSubmit(query: String?): Boolean {
//                    return true
//                }
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//                    if (newText!!.isNotEmpty()) {
//                        viewLifecycleOwner.lifecycleScope.launch {
//                            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                                viewModel.flow.collect { it ->
//                                    it.data?.bestSeller.let {
//                                        val list = viewModel.search(it, newText)
//                                        if (list != null) {
//                                            adapterVertical.updateRecycler(list.toMutableList())
//                                        }
//                                    }
//
//                                }
//                            }
//                        }
//
//
//                    }
//                    return true
//                }
//            })
//        }
//    }
    fun search() {
        val search = binding.searchBar
        if (search != null) {
            val mySearch = search as SearchView
            mySearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        viewLifecycleOwner.lifecycleScope.launch {
                            repeatOnLifecycle(Lifecycle.State.STARTED) {
                                viewModel.flowOuter.collect {
                                    it.data?.bestSeller.let {
                                        val list = viewModel.search1(it, newText)
                                        if (list != null) {
                                            adapterVertical.updateRecycler(list.toMutableList())
                                        }
                                    }

                                }
                            }
                        }


                    }
                    return true
                }
            })
        }
    }
}