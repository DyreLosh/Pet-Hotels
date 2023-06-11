package com.dyrelosh.pethotels.presentation.ui.user.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dyrelosh.pethotels.R
import com.dyrelosh.pethotels.adapter.user.HotelAdapter
import com.dyrelosh.pethotels.adapter.user.PopularHotelAdapter
import com.dyrelosh.pethotels.databinding.FragmentSearchBinding
import com.dyrelosh.pethotels.domain.models.UserHotelModel
import com.dyrelosh.pethotels.presentation.ui.user.UserBaseFragment
import com.dyrelosh.pethotels.presentation.ui.user.main.MainViewModel
import com.dyrelosh.pethotels.presentation.ui.user.opencard.OpenCardFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale

class SearchFragment : UserBaseFragment() {
    lateinit var binding: FragmentSearchBinding
    lateinit var recyclerView: RecyclerView
    lateinit var searchView: SearchView
    private var list = ArrayList<UserHotelModel>()
    private lateinit var adapter: HotelAdapter
    override val showBottomNavigationView = true
    private val viewModel by viewModel<SearchViewModel>()
    private val recyclerAdapter by lazy { PopularHotelAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getHotels()
    }
    //TODO rename fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        recyclerView = binding.searchRecycler
        searchView = binding.searchView
        recyclerView.setHasFixedSize(true)
        adapter = HotelAdapter(list)
        recyclerView.adapter = adapter
        viewModel.response.observe(viewLifecycleOwner) { response ->
            list.addAll(response)
        }

        searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                filterList(p0)
                return true
            }
        })
        recyclerAdapter.onItemClick = { it ->
            OpenCardFragment.newInstance(it)
            findNavController().navigate(
                R.id.action_searchFragment_to_openCardFragment,
                bundleOf("OOO" to it)
            )
        }
        return binding.root
    }

    private fun filterList(newText: String?) {
        if (newText != null) {
            val filteredList = ArrayList<UserHotelModel>()
            filteredList.clear()
            for (i in list) {
                if(i.name.toLowerCase(Locale.ROOT).contains(newText)) {
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()) {
                filteredList.clear()
            }
            else {
                adapter.submitList(filteredList)

            }
        }

    }


}