package com.example.androidimbdapi.presentation.detail

import com.example.androidimbdapi.domain.entity.Title
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.OneExecution
import moxy.viewstate.strategy.alias.Skip

@AddToEndSingle
interface MovieDetailView : MvpView {

    @OneExecution
    fun showDetail(details: Title)

    fun showProgressbar()

    fun hideProgressbar()

    @Skip
    fun showError(e: Throwable)
}