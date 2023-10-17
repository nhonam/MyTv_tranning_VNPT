package com.example.android.marsphotos.ui.film.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.marsphotos.databinding.ChildItemBinding
import com.example.android.marsphotos.ui.film.ultil.ChildItem
import io.reactivex.annotations.NonNull


class ChildItemAdapter  // Constructor
 (private val ChildItemList: List<ChildItem>) :
    RecyclerView.Adapter<ChildItemAdapter.ViewHolder>() {

    lateinit var binding : ChildItemBinding
    @NonNull
    override fun onCreateViewHolder(
        @NonNull viewGroup: ViewGroup,
        i: Int
    ): ViewHolder {

        binding = ChildItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        @NonNull holder: ViewHolder,
        position: Int
    ) {
        holder.view.childItemTitle.text = ChildItemList[position].childItemTitle

        Glide.with(holder.view.imgChildItem)
            .load(ChildItemList[position].imageUrl)
//            .apply(RequestOptions().override(50, 50))
            .into(holder.view.imgChildItem)
    }

    override fun getItemCount(): Int {

        return ChildItemList.size
    }

    class ViewHolder(var view: ChildItemBinding) :RecyclerView.ViewHolder(view.root){

    }

}