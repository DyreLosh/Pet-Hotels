package com.dyrelosh.pethotels.presentation.ui.user.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dyrelosh.pethotels.databinding.FragmentMainBinding
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.adapter.user.PopularHotelAdapter
import com.dyrelosh.pethotels.domain.companymodels.Hotel
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : UserBaseFragment() {

    override val showBottomNavigationView = true
    lateinit var binding: FragmentMainBinding
    private val listAdd = mutableListOf<Hotel>()
    private val viewModel by viewModel<MainViewModel>()
    private val recyclerAdapter by lazy { PopularHotelAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel.getHotels()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.popularRecycler.adapter = recyclerAdapter


        viewModel.response.observe(viewLifecycleOwner) { response ->
            if(viewModel.number == 0) {
                listAdd.addAll(response)
                viewModel.number++

                recyclerAdapter.submitList(listAdd)
            }
            if (listAdd.isNotEmpty()) {
                binding.mainRecyclerProgressBar.visibility = View.INVISIBLE
                binding.popularRecycler.visibility = View.VISIBLE

            }
            else {
                binding.mainRecyclerProgressBar.visibility = View.VISIBLE
                binding.popularRecycler.visibility = View.INVISIBLE
            }


            val filteredList = mutableListOf<Hotel>()

            binding.otherCardItemMain.setOnClickListener {
                filteredList.clear()
                setButtonColor(false, false, false, true)
                for (i in listAdd) {
                    if (i.other) {
                        filteredList.add(i)
                        recyclerAdapter.submitList(filteredList)
                    }
                }
            }
            binding.catCardItemMain.setOnClickListener {
                filteredList.clear()
                setButtonColor(true, false, false, false)
                for (i in listAdd) {
                    if (i.cat) {
                        filteredList.add(i)
                        recyclerAdapter.submitList(filteredList)
                    }
                }
            }
            binding.dogCardItemMain.setOnClickListener {
                filteredList.clear()
                setButtonColor(false, true, false, false)
                for (i in listAdd) {
                    if (i.dog) {
                        filteredList.add(i)
                        recyclerAdapter.submitList(filteredList)
                    }
                }
            }
            binding.rodentCardItemMain.setOnClickListener {
                filteredList.clear()
                setButtonColor(false, false, true, false)
                for (i in listAdd) {
                    if (i.rodent) {
                        filteredList.add(i)
                        recyclerAdapter.submitList(filteredList)
                    }
                }
            }
        }

        recyclerAdapter.onItemClick = {
            findNavController().navigate(
                R.id.action_mainFragment2_to_openCardFragment,
                bundleOf("OOO" to it)
            )
        }
    }

    fun setButtonColor(cat: Boolean, dog: Boolean, rodent: Boolean, other: Boolean) {
        when {
            cat -> {
                binding.catCardItemMain.setBackgroundColor(resources.getColor(R.color.gray))
                binding.dogCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
                binding.rodentCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
                binding.otherCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
            }
            dog -> {
                binding.catCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
                binding.dogCardItemMain.setBackgroundColor(resources.getColor(R.color.gray))
                binding.rodentCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
                binding.otherCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
            }
            rodent -> {
                binding.catCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
                binding.dogCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
                binding.rodentCardItemMain.setBackgroundColor(resources.getColor(R.color.gray))
                binding.otherCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
            }
            other -> {
                binding.catCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
                binding.dogCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
                binding.rodentCardItemMain.setBackgroundColor(resources.getColor(R.color.pet_one))
                binding.otherCardItemMain.setBackgroundColor(resources.getColor(R.color.gray))
            }
        }
    }
}

