package com.example.android.marsphotos.ui.film.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.marsphotos.ui.film.Fragment.FilmSeriesFragment
import com.example.android.marsphotos.ui.film.Fragment.FimlRetailFragment
import com.example.android.marsphotos.ui.television.Fragment.AllchannelFragment
import com.example.android.marsphotos.ui.television.Fragment.InternationalFragment


private const val NUM_TABS_FILM = 2
public class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS_FILM
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FimlRetailFragment()
//            1 -> return InternationalFragment()
        }
        return FilmSeriesFragment()
    }
}