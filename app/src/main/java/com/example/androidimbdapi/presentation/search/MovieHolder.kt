package com.example.androidimbdapi.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidimbdapi.databinding.ItemMovieBinding
import com.example.androidimbdapi.domain.entity.SearchResult

class MovieHolder (
    private val binding: ItemMovieBinding,
    private val action: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root){

    fun bind(item: SearchResult){
        with(binding){
            Glide.with(itemView.context)
                .load(item.image)
                .into(ivMoviePoster)
            tvMovieTitle.text = item.title
            tvMovieDescription.text = item.description
        }

        itemView.setOnClickListener{
            action(item.id)
        }
    }

    companion object{
        fun create(
            parent: ViewGroup,
            action: (String) -> Unit
        ) = MovieHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), action
        )
    }
}