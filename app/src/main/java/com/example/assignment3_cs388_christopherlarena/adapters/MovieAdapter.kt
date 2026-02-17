package com.example.assignment3_cs388_christopherlarena.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment3_cs388_christopherlarena.R
import com.example.assignment3_cs388_christopherlarena.data.Onboarding

class MovieAdapter(private val movies: List<Onboarding>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val moviePoster: ImageView = itemView.findViewById(R.id.movie_poster)
        private val movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        private val movieDescription: TextView = itemView.findViewById(R.id.movie_description)

        fun bind(movie: Onboarding) {
            movieTitle.text = movie.title
            movieDescription.text = movie.description

            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500/" + movie.posterPath)
                .into(moviePoster)
        }
    }
}
