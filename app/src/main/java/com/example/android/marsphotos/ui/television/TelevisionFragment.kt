package com.example.android.marsphotos.ui.television

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.android.marsphotos.databinding.FragmentTelevisionBinding
import com.example.android.marsphotos.ui.television.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


val CategoryArray    = arrayOf(
    "Tất cả",
    "Quốc tế"
)

class TelevisionFragment : Fragment() {

    private lateinit var televisionFragmentBinding : FragmentTelevisionBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        televisionFragmentBinding = FragmentTelevisionBinding.inflate(inflater, container, false)

        setupTabLayout()

        // Inflate the layout for this fragment
        return  televisionFragmentBinding.root;
    }

    fun setupTabLayout() {
        val viewPager = televisionFragmentBinding.viewPager
        val tabLayout = televisionFragmentBinding.tabLayout
        val fragmentManager: FragmentManager = getChildFragmentManager()


        val adapter = ViewPagerAdapter(fragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = CategoryArray[position]
        }.attach()
    }

}