package com.example.android.marsphotos.ui.television.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.marsphotos.data.model.Television.Channel
import com.example.android.marsphotos.databinding.ItemChannelBinding


class RCVChanelAdapter(
    // on below line we are passing variables
    // as course list and context
    private val channelList: List<Channel>,
    private val context: Context
) : RecyclerView.Adapter<RCVChanelAdapter.ViewHolder>() {


    lateinit var binding: ItemChannelBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RCVChanelAdapter.ViewHolder {
        binding = ItemChannelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RCVChanelAdapter.ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.

        Glide.with(context).load(channelList[position].CONTENT_IMAGE_SMALL).into(holder.view.imageChannel);


    }

    override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return channelList.size
    }

    class ViewHolder(var view: ItemChannelBinding) :RecyclerView.ViewHolder(view.root){

    }


}
