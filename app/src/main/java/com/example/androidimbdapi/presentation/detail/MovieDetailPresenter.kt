package com.example.androidimbdapi.presentation.detail

import android.util.Log
import com.example.androidimbdapi.domain.usecase.getTitleUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import moxy.MvpPresenter
import javax.inject.Inject

class MovieDetailPresenter @Inject constructor(
    private val getTitleUseCase: getTitleUseCase
) : MvpPresenter<MovieDetailView>() {

    private val disposable = CompositeDisposable()

    fun loadDetail(id: String){
        disposable += getTitleUseCase(id)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showProgressbar()
            }
            .doAfterTerminate {
                viewState.hideProgressbar()
            }
            .subscribeBy(
                onSuccess = { details ->
                    viewState.showDetail(details)
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