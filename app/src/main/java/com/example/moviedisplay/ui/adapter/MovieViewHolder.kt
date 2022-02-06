package com.example.moviedisplay.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedisplay.R
import com.example.moviedisplay.databinding.ItemMovieBinding
import com.example.moviedisplay.ui.Movie


class MovieViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemMovieBinding.bind(view)

    fun render(movieModel:Movie,onClickListener:(Movie) -> Unit){
        binding.textViewMovieName.text =   movieModel.title
        binding.textViewMovieDescription.text = movieModel.overview
        Glide.with(binding.imageViewMovie.context).load(
            "http://image.tmdb.org/t/p/w185/"+movieModel.poster_path+"?api_key=28b80b41ebf312e0ba2909f4472d67b6").into(binding.imageViewMovie)

        itemView.setOnClickListener{ onClickListener(movieModel) }
    }
}