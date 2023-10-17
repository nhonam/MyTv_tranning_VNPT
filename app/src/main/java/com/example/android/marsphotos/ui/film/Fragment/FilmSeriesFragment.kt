package com.example.android.marsphotos.ui.film.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.marsphotos.R


/**
 * A simple [Fragment] subclass.
 * Use the [FilmSeriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FilmSeriesFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_series, container, false)
    }


}