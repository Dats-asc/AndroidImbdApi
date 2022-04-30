package com.example.androidimbdapi.presentation.search

import androidx.recyclerview.widget.DiffUtil
import com.example.androidimbdapi.domain.entity.SearchResult

class MovieDiffUtills(
    private val oldList: List<SearchResult>,
    private val newList: List<SearchResult>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldItemPosition == newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].id == newList[newItemPosition].id)
    }
}