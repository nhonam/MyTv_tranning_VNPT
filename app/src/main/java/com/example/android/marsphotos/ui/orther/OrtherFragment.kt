package com.example.android.marsphotos.ui.orther

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.android.marsphotos.R
import com.example.android.marsphotos.data.model.Orther.Info
import com.example.android.marsphotos.databinding.FragmentOrtherBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrtherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrtherFragment : Fragment() {

    lateinit var fragmentOrtherBinding: FragmentOrtherBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val model : OrtherViewModel by viewModels()

        model.getData().observe(viewLifecycleOwner, Observer<List<Info>> { data->

           fragmentOrtherBinding.idAccount.text = data.get(1).value
           fragmentOrtherBinding.emailUser.text = data.get(0).value
           fragmentOrtherBinding.nameUser.text = data.get(7).value


        })



        fragmentOrtherBinding = FragmentOrtherBinding.inflate(inflater, container, false)
        return fragmentOrtherBinding.root
    }


}