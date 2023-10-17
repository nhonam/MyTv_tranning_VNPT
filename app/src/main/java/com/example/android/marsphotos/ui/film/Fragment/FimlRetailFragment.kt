package com.example.android.marsphotos.ui.film.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.marsphotos.databinding.FragmentFimlRetailBinding
import com.example.android.marsphotos.ui.film.FilmViewModel
import com.example.android.marsphotos.ui.film.adapter.ParentItemAdapter
import com.example.android.marsphotos.ui.film.ultil.ChildItem
import com.example.android.marsphotos.ui.film.ultil.ParentItem


/**
 * A simple [Fragment] subclass.
 * Use the [FimlRetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FimlRetailFragment : Fragment() {
    private lateinit var binding : FragmentFimlRetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFimlRetailBinding.inflate(inflater, container, false)

        val model: FilmViewModel by viewModels()



        val layoutManager = LinearLayoutManager(
            context
        )



        val parentItemAdapter = ParentItemAdapter(ParentItemList())

        binding.parentRecyclerview
            .setAdapter(parentItemAdapter)
        binding.parentRecyclerview
            .setLayoutManager(layoutManager)


        model.getData().observe(viewLifecycleOwner, Observer<com.example.android.marsphotos.data.model.film.Data> {
            //set UI for recycle view
//            fimlLatestAdapter = FilmLatestAdapter(requireContext(), it.DATA)
//            binding.recyclerViewFilm.adapter = fimlLatestAdapter;

        })


        return binding.root
    }

//data test
 fun ParentItemList(): MutableList<ParentItem> {
    val itemList: MutableList<ParentItem> = ArrayList()
    val item = ParentItem(
        "Mới Nhất",
        ChildItemList()!!
    )
    itemList.add(item)
    val item1 = ParentItem(
        "Phim Việt chiếu rạp",
        ChildItemList()!!
    )
    itemList.add(item1)
    val item2 = ParentItem(
        "Hollywood",
        ChildItemList()!!
    )
    itemList.add(item2)
    val item3 = ParentItem(
        "Hành động",
        ChildItemList()!!
    )
    itemList.add(item3)
    return itemList
}

    // Method to pass the arguments
    // for the elements
    // of child RecyclerView
    private fun ChildItemList(): List<ChildItem>? {
        val ChildItemList: MutableList<ChildItem> = ArrayList()
        ChildItemList.add(ChildItem("Card 1","https://s2129132.cdn.mytvnet.vn/vimages/408x232/b6/68/81/17/74/43/b6817-lnhcttng1-content-mytv.jpg"))
        ChildItemList.add(ChildItem("Card 2","https://s2129132.cdn.mytvnet.vn/vimages/408x232/22/2d/da/aa/a7/73/22daa-laicngbitemyuanh1-content-mytv.jpg"))
        ChildItemList.add(ChildItem("Card 3","https://s2129132.cdn.mytvnet.vn/vimages/408x232/5e/e7/7f/f0/03/35/5e7f0-lkhanhkhanhnhtthng1-content-mytv.jpg"))
        ChildItemList.add(ChildItem("Card 4","https://s2129132.cdn.mytvnet.vn/vimages/408x232/dd/df/f4/41/1c/c2/ddf41-lcaolng1-content-mytv.jpg"))
        return ChildItemList
    }

}