package com.example.assignment3_cs388_christopherlarena

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.example.assignment3_cs388_christopherlarena.adapters.MovieAdapter
import com.example.assignment3_cs388_christopherlarena.data.Onboarding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers

class MainActivity : AppCompatActivity() {

    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieRecyclerView = findViewById(R.id.movie_recycler_view)
        movieRecyclerView.layoutManager = LinearLayoutManager(this)

        fetchMovies()
    }

    private fun fetchMovies() {
        val client = AsyncHttpClient()
        val url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed"

        client.get(url, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                val gson = Gson()
                val movieType = object : TypeToken<List<Onboarding>>() {}.type
                val movies: List<Onboarding> = gson.fromJson(json.jsonObject.getJSONArray("results").toString(), movieType)

                movieAdapter = MovieAdapter(movies)
                movieRecyclerView.adapter = movieAdapter
            }

            override fun onFailure(statusCode: Int, headers: Headers?, response: String?, throwable: Throwable?) {
                // Handle failure
            }
        })
    }
}
