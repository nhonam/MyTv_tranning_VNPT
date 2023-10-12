package com.example.android.marsphotos.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.example.android.marsphotos.data.db.entities.LiveEvent
import com.example.android.marsphotos.data.db.entities.Slide
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

//        val imageList = ArrayList<SlideModel>()
//        model.getSlides().observe(viewLifecycleOwner, Observer<List<Slide>>{ slides ->
//            // update UI
//            for (slide in slides) {
//
//                imageList.add(SlideModel(slide.logo,slide.title))
//                fragmentHomeBinding.imageSlider.setImageList(imageList)
//            }
//            fragmentHomeBinding.imageSlider.setImageList(imageList)
//
//        })

        val liveEventList = ArrayList<LiveEvent>()
        model.getLiveEvents().observe(viewLifecycleOwner, Observer<List<LiveEvent>>{ liveEvents ->
            // update UI
            for (liveEvent in liveEvents) {

                liveEventList.add(LiveEvent(liveEvent.content_id,liveEvent.content_title,liveEvent.content_image_url))

            }

            adapter = LiveEventAdapter(requireActivity(), liveEventList)

            fragmentHomeBinding.recyclerView.adapter = adapter

        })





        return fragmentHomeBinding.root;
    }






}