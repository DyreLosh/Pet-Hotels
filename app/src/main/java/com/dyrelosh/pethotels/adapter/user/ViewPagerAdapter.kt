package com.dyrelosh.pethotels.adapter.user

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dyrelosh.pethotels.presentation.ui.user.main.MainFragment
import com.dyrelosh.pethotels.presentation.ui.user.main.ViewPagerFragment

class ViewPagerAdapter(fragment: MainFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return ViewPagerFragment(position)
    }
}