package com.example.androidimbdapi.presentation.search

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidimbdapi.domain.entity.SearchResult

class MovieAdapter (
    private val movies: ArrayList<SearchResult>,
    private val action: (String) -> Unit
) : RecyclerView.Adapter<MovieHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieHolder = MovieHolder.create(parent, action)

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun updateData(newData: ArrayList<SearchResult>){
        val callback = MovieDiffUtills(movies, newData)
        val diffResult = DiffUtil.calculateDiff(callback)
        diffResult.dispatchUpdatesTo(this)

        movies.clear()
        movies.addAll(newData)
    }

    override fun getItemCount(): Int = movies.size
}