package com.example.android.marsphotos.ui.home.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.android.marsphotos.data.db.entities.LiveEvent
import com.example.android.marsphotos.databinding.ItemListEventBinding


class LiveEventAdapter(private val context: Context, private val dataSet:ArrayList<LiveEvent>
)
    : RecyclerView.Adapter<LiveEventAdapter.ViewHolder>()
{
    lateinit var binding: ItemListEventBinding
    class ViewHolder(var view: ItemListEventBinding) :RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemListEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.name.text = dataSet[position].content_title.toString()
        val contentImageUrl: String = dataSet[position].content_image_url.toString()
        Log.d("abc", contentImageUrl)
//        Glide.with(context).load(dataSet[position].content_image_url).into(holder.view.image);
        Glide.with(context)
            .load(contentImageUrl)
//            .apply(RequestOptions().override(50, 50))
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("abc", e?.message ?: "")
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("abc", "gggg")
                    return false
                }
            })
            .into(holder.view.image)
    }
}