package com.example.androidimbdapi.presentation.search

import com.example.androidimbdapi.domain.entity.SearchResult
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface SearchView : MvpView {

    fun showProgressbar()

    fun hideProgressbar()

    @OneExecution
    fun updateMovieAdapter(movies: ArrayList<SearchResult>)

    @Skip
    fun showError(error: Throwable)
}