package com.example.androidimbdapi.presentation.search

import android.util.Log
import com.example.androidimbdapi.domain.usecase.getMoviesByRequestUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import moxy.MvpPresenter
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val getMoviesByRequestUseCase: getMoviesByRequestUseCase
) : MvpPresenter<SearchView>() {

    private val disposable = CompositeDisposable()

    fun onSearchMovie(request: String) {
        disposable += getMoviesByRequestUseCase(request)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showProgressbar()
            }
            .doAfterTerminate {
                viewState.hideProgressbar()
            }
            .subscribeBy(
                onSuccess = { movieSearch ->
                    viewState.updateMovieAdapter(movieSearch.results)
                }, onError = {
                    Log.e("", it.message.orEmpty())
                    viewState.showError(it)
                }
            )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()
    }
}