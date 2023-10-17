package com.example.android.marsphotos.ui.film.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.marsphotos.data.model.film.Film
import com.example.android.marsphotos.databinding.ItemLatestFilmBinding


class FilmLatestAdapter(private val context: Context, private val dataSet:List<Film>
)
    : RecyclerView.Adapter<FilmLatestAdapter.ViewHolder>()
{
    lateinit var binding: ItemLatestFilmBinding
    class ViewHolder(var view: ItemLatestFilmBinding) :RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemLatestFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.nameLatestFiml.text = dataSet[position].CONTENT_TITLE
        val contentImageUrl: String = dataSet[position].CONTENT_IMAGE_URL

//        Glide.with(context).load(dataSet[position].content_image_url).into(holder.view.image);
        Glide.with(context)
            .load(contentImageUrl)
//            .apply(RequestOptions().override(50, 50))
            .into(holder.view.imageLatestFil)
    }
}