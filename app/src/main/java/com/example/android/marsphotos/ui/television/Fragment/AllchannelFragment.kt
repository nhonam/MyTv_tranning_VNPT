package com.example.android.marsphotos.ui.television.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.marsphotos.data.model.Television.Channel
import com.example.android.marsphotos.databinding.FragmentAllchannelBinding
import com.example.android.marsphotos.ui.television.TelevisionViewModel
import com.example.android.marsphotos.ui.television.adapter.RCVChanelAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [AllchannelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllchannelFragment : Fragment() {
    private lateinit var fragmentAllchannelBinding : FragmentAllchannelBinding


    lateinit var channelRVAdapter: RCVChanelAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentAllchannelBinding = FragmentAllchannelBinding.inflate(inflater, container, false)


        val model: TelevisionViewModel by viewModels()
        //add data courseList
        model.getChannels().observe(viewLifecycleOwner, Observer<List<Channel>>{ slides ->
            // update UI
            val layoutManager = GridLayoutManager(context, 3)
            channelRVAdapter = RCVChanelAdapter(slides, requireActivity())
            fragmentAllchannelBinding.idRVCourses.layoutManager = layoutManager
            fragmentAllchannelBinding.idRVCourses.adapter = channelRVAdapter

        })


        return fragmentAllchannelBinding.root
    }



}