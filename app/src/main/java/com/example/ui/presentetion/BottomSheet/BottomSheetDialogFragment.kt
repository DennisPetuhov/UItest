package com.example.ui.presentetion.BottomSheet

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView

import androidx.lifecycle.ViewModelProvider

import com.example.ui.R

import com.example.ui.databinding.BottomSheetBinding
import com.example.ui.presentetion.PhonesFragmentViewModel

import com.example.ui.presentetion.spinner.SpinnerAdapterBrand
import com.example.ui.presentetion.spinner.SpinnerAdapterPrice
import com.example.ui.presentetion.spinner.SpinnerAdapterSize
import kotlinx.coroutines.launch


// TODO: Customize parameter argument names
const val ARG_ITEM_COUNT = "item_count"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    BottomSheetDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class BottomSheetDialogFragment : BottomSheetDialogFragment() {
    lateinit var filteredPhonesByBottomSheet: FilteredPhonesByBottomSheet
    lateinit var vm: PhonesFragmentViewModel

    private var _binding: BottomSheetBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TransparentBackgroundBottomSheet)
    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = BottomSheetBinding.inflate(inflater, container, false)
        vm = ViewModelProvider(requireActivity()).get(PhonesFragmentViewModel::class.java)

        return binding.root


    }
    fun dismissButton(){
        binding.imageButton.setOnClickListener{
            dismiss()
        }
        binding.orangeButtonDone.setOnClickListener{
            dismiss()
        }
    }

//    fun sendFilterToRecyckerView(
//    ) {
//        binding.orangeButtonDone.setOnClickListener {
//            println(vm.filter.value.toString())
//            findNavController().navigate(
//                R.id.action_bottomSheetDialogFragment_to_phonesFragment)
//        }
//    }

    var priceArray = arrayListOf(Pair(0, 500), Pair(500, 1000), Pair(1000, 3000))
    private fun initSpinner1() {
        filteredPhonesByBottomSheet = FilteredPhonesByBottomSheet(null, null)
//        val priceList=resources.getStringArray(R.array.price_spinner)
        val priceList = (priceArray)
        val spinnerPrice = binding.spinnerPrice

        spinnerPrice.adapter = SpinnerAdapterPrice(requireContext(), priceList)
        spinnerPrice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                vm.print()
                vm.getFilterPrice(priceList[position])
                println("!!!!!!++++${vm.flow.value.data?.bestSeller}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val brandList = resources.getStringArray(R.array.brand_spinner)
        val spinnerBrand = binding.spinnerBrand
        spinnerBrand.adapter = SpinnerAdapterBrand(requireContext(), brandList)
        spinnerBrand.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                vm.getFilterName(brandList[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val sizeList = resources.getStringArray(R.array.size_spinner)
        val spinnerSize = binding.spinnerSize
        spinnerSize.adapter = SpinnerAdapterSize(requireContext(), sizeList)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initSpinner1()
        dismissButton()

//        activity?.findViewById<Spinner>(R.id.spinner_brand)?.layoutManager =
//            LinearLayoutManager(context)
//        activity?.findViewById<RecyclerView>(R.id.list)?.adapter =
//            arguments?.getInt(ARG_ITEM_COUNT)?.let { ItemAdapter(it) }
    }
//
//    private inner class ViewHolder internal constructor(binding: FragmentBottomSheetDialogListDialogItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        internal val text: TextView = binding.text
//    }

//    private inner class ItemAdapter internal constructor(private val mItemCount: Int) :
//        RecyclerView.Adapter<ViewHolder>() {
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//            return ViewHolder(
//                FragmentBottomSheetDialogListDialogItemBinding.inflate(
//                    LayoutInflater.from(
//                        parent.context
//                    ), parent, false
//                )
//            )
//
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            holder.text.text = position.toString()
//        }
//
//        override fun getItemCount(): Int {
//            return mItemCount
//        }
//    }

//    companion object {
//
//        // TODO: Customize parameters
//        fun newInstance(itemCount: Int): BottomSheetDialogFragment =
//            BottomSheetDialogFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_ITEM_COUNT, itemCount)
//                }
//            }
//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}