package com.example.android.marsphotos.ui.television.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.marsphotos.R
import com.example.android.marsphotos.databinding.FragmentAllchannelBinding
import com.example.android.marsphotos.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [AllchannelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllchannelFragment : Fragment() {
    private lateinit var fragmentAllchannel : FragmentAllchannelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentAllchannel = FragmentAllchannelBinding.inflate(inflater, container, false)


        return fragmentAllchannel.root
    }



}