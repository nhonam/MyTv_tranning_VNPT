package com.example.android.marsphotos.ui.film

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.android.marsphotos.R
import com.example.android.marsphotos.databinding.FragmentFilmBinding
import com.example.android.marsphotos.ui.film.adapter.ViewPagerAdapter
import com.example.android.marsphotos.ui.television.CategoryArray
import com.google.android.material.tabs.TabLayoutMediator

val CategoryArray_fiml   = arrayOf(
    "Phim lẻ",
    "Phim bộ"
)
/**
 * A simple [Fragment] subclass.
 * Use the [FilmFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmFragment : Fragment() {

    private lateinit var fragmentFilmBinding: FragmentFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentFilmBinding = FragmentFilmBinding.inflate(inflater, container, false)



        setupTabLayout()
        return  fragmentFilmBinding.root;

    }

    fun setupTabLayout() {
        val viewPager = fragmentFilmBinding.viewPagerFilm
        val tabLayout = fragmentFilmBinding.tabLayoutFilm
        val fragmentManager: FragmentManager = getChildFragmentManager()


        val adapter = ViewPagerAdapter(fragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = CategoryArray_fiml[position]
        }.attach()
    }


}