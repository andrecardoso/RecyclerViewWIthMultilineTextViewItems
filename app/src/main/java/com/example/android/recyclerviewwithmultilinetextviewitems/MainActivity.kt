package com.example.android.recyclerviewwithmultilinetextviewitems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.recyclerviewwithmultilinetextviewitems.databinding.ActivityMainBinding
import com.example.android.recyclerviewwithmultilinetextviewitems.databinding.MovieItemBinding

private val movies = listOf(
    Movie(
        "A",
        "a"
    ),
    Movie(
        "B",
        "b"
    ),
    Movie(
        "C",
        "c"
    ),
    Movie(
        "D",
        "d"
    ),
    Movie(
        "E",
        "e"
    ),
    Movie(
        "F",
        "f"
    ),
    Movie(
        "G",
        "g"
    ),
    Movie(
        "What If...?",
        "Another movies"
    ),

    Movie(
        "Black Widow",
        "Another movies"
    ),

    Movie(
        "Captain America",
        "Another s"
    ),

    Movie(
        "Ma Rainey's Black Bottom",
        "Another s"
    ),

    Movie(
        "Black Panther",
        "T'Challa, heir to the hidden but advanced kingdom of Wakanda, must step forward to lead his people."
    ),
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val movieAdapter = MovieAdapter()
        binding.recycler.adapter = movieAdapter
        movieAdapter.submitList(movies)


        val secondMovieAdapter = MovieAdapter()
        binding.recyclerReverse.adapter = secondMovieAdapter
        secondMovieAdapter.submitList(movies.reversed())
    }
}

class MovieAdapter : ListAdapter<Movie, MovieAdapter.ViewHolder>(MovieDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }


    class ViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.title.text = movie.title
            binding.subtitle.text = movie.subtitle
        }
    }

}


class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) = oldItem === newItem

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) = oldItem == newItem

}

data class Movie(val title: String, val subtitle: String)
