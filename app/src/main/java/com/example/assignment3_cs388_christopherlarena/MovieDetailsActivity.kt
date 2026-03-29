package com.example.assignment3_cs388_christopherlarena

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.assignment3_cs388_christopherlarena.data.Movie

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var movieBackdrop: ImageView
    private lateinit var movieTitle: TextView
    private lateinit var movieReleaseDate: TextView
    private lateinit var movieRating: TextView
    private lateinit var movieVoteCount: TextView
    private lateinit var movieOverview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        movieBackdrop = findViewById(R.id.movie_backdrop)
        movieTitle = findViewById(R.id.movie_title_detail)
        movieReleaseDate = findViewById(R.id.movie_release_date)
        movieRating = findViewById(R.id.movie_rating)
        movieVoteCount = findViewById(R.id.movie_vote_count)
        movieOverview = findViewById(R.id.movie_overview_detail)

        val movie = intent.getSerializableExtra("MOVIE_EXTRA") as Movie

        movieTitle.text = movie.title
        movieReleaseDate.text = "Release Date: ${movie.releaseDate}"
        movieRating.text = "Rating: ${movie.voteAverage}/10"
        movieVoteCount.text = "Votes: ${movie.voteCount}"
        movieOverview.text = movie.description

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + movie.backdropPath)
            .into(movieBackdrop)
    }
}
