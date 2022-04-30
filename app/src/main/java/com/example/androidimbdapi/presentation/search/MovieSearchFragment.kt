package com.example.androidimbdapi.presentation.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.androidimbdapi.R
import com.example.androidimbdapi.databinding.FragmentMovieSearchBinding
import com.example.androidimbdapi.domain.entity.SearchResult
import com.example.androidimbdapi.presentation.detail.MovieDetailFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

val MOVIE_ID = "MOVIE_ID"

@AndroidEntryPoint
class MovieSearchFragment : MvpAppCompatFragment(), SearchView {

    private lateinit var binding: FragmentMovieSearchBinding

    private lateinit var movieAdapter: MovieAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: SearchPresenter

    @ProvidePresenter
    fun providePresenter(): SearchPresenter = presenter

    private var movieList = arrayListOf<SearchResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentMovieSearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentMovieSearchBinding.inflate(inflater, container, false).let {
        binding = FragmentMovieSearchBinding.inflate(inflater, container, false)
        initViews()
        binding.root
    }

    private fun initViews() {
        initMovieAdapter()
        with(binding) {
            search.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener,
                androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    presenter.onSearchMovie(p0.orEmpty())
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return true
                }

            })
        }
    }

    private fun initMovieAdapter() {
        movieAdapter = MovieAdapter(movieList) { movieId ->
            parentFragmentManager.beginTransaction().run {
                addToBackStack(null)
                replace(R.id.fragment_container_view, MovieDetailFragment().apply {
                    arguments = bundleOf(MOVIE_ID to movieId)
                })
                commit()
            }
        }
        binding.rvMovies.adapter = movieAdapter
    }

    override fun showProgressbar() {
        binding.progrssbar.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        binding.progrssbar.visibility = View.GONE
    }

    override fun updateMovieAdapter(movies: ArrayList<SearchResult>) {
        movieAdapter.updateData(movies)
    }

    override fun showError(error: Throwable) {
        Snackbar.make(binding.root, error.message.orEmpty(), Snackbar.LENGTH_SHORT).show()
    }
}