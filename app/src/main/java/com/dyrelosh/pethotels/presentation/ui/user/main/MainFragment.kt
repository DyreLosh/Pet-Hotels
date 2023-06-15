package com.dyrelosh.pethotels.presentation.ui.user.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.adapter.user.PopularHotelAdapter
import com.dyrelosh.pethotels.data.preferences.PreferenceStorage
import com.dyrelosh.pethotels.databinding.FragmentMainBinding
import com.dyrelosh.pethotels.domain.companymodels.Hotel
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import com.dyrelosh.pethotels.presentation.ui.user.opencard.OpenCardFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : UserBaseFragment() {

    override val showBottomNavigationView = true
    lateinit var binding: FragmentMainBinding
    private val listAdd = mutableListOf<Hotel>()
    private val viewModel by viewModel<MainViewModel>()
    private val recyclerAdapter by lazy { PopularHotelAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getHotels()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        Toast.makeText(
            requireContext(),
            PreferenceStorage(requireContext()).accessToken.toString(),
            Toast.LENGTH_SHORT
        ).show()

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.popularRecycler.adapter = recyclerAdapter

        viewModel.response.observe(viewLifecycleOwner) { response ->
            listAdd.addAll(response)
            recyclerAdapter.submitList(listAdd)
            val filteredList = mutableListOf<Hotel>()
            for (i in listAdd) {


            }

        }


        recyclerAdapter.onItemClick = {
            findNavController().navigate(
                R.id.action_mainFragment2_to_openCardFragment,
                bundleOf("OOO" to it)
            )
        }
    }
}

