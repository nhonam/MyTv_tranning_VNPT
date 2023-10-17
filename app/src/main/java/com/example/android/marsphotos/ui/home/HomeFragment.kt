package com.example.android.marsphotos.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.denzcoskun.imageslider.models.SlideModel
import com.example.android.marsphotos.data.model.Home.Data
import com.example.android.marsphotos.databinding.FragmentHomeBinding
import com.example.android.marsphotos.ui.home.adapter.LiveEventAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding : FragmentHomeBinding
    private lateinit var adapter: LiveEventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        val model: HomeViewModel by viewModels()

        val imageList = ArrayList<SlideModel>()
        model.getData().observe(viewLifecycleOwner, Observer<Data?>{ data ->
            // update UI

            //set UI for slide
            data.trailer.data.map {

                imageList.add(SlideModel(it.CONTENT_IMAGE_URL,it.CONTENT_TITLE))
            }
            fragmentHomeBinding.imageSlider.setImageList(imageList)


            //set UI for recycle view list Event live
            adapter = LiveEventAdapter(requireActivity(), data.service)
            fragmentHomeBinding.recyclerView.adapter = adapter

        })

        return fragmentHomeBinding.root;
    }






}