package com.example.android.marsphotos.ui.television.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.marsphotos.ui.television.Fragment.AllchannelFragment
import com.example.android.marsphotos.ui.television.Fragment.InternationalFragment


private const val NUM_TABS = 2

public class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return AllchannelFragment()
//            1 -> return InternationalFragment()
        }
        return InternationalFragment()
    }
}