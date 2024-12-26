package com.example.myanimefavorit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AnimeAdapter(private val animeList: ArrayList<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val (name, description, rating, genre, photo) = animeList[position]
        holder.titleView.text = name
        holder.overviewView.text = description
        holder.ratingView.text = "Rating: $rating"
        holder.genreView.text = "Genre: $genre"
        holder.imageView.setImageResource(photo) // Load image

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(animeList[holder.adapterPosition])
        }
    }

    override fun getItemCount() = animeList.size

    class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.img_anime)
        val titleView: TextView = view.findViewById(R.id.tv_animetitle)
        val overviewView: TextView = view.findViewById(R.id.tv_anime_description)
        val ratingView: TextView = view.findViewById(R.id.tv_anime_rating)   // Rating TextView
        val genreView: TextView = view.findViewById(R.id.tv_anime_genre)     // Genre TextView
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Anime)
    }
}
