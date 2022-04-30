package com.example.androidimbdapi.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.androidimbdapi.R
import com.example.androidimbdapi.databinding.FragmentMovieDetailBinding
import com.example.androidimbdapi.databinding.FragmentMovieSearchBinding
import com.example.androidimbdapi.domain.entity.Title
import com.example.androidimbdapi.presentation.search.MOVIE_ID
import com.example.androidimbdapi.presentation.search.SearchPresenter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailFragment : MvpAppCompatFragment(), MovieDetailView {

    private lateinit var movieId: String

    private lateinit var binding: FragmentMovieDetailBinding

    @Inject
    @InjectPresenter
    lateinit var presenter: MovieDetailPresenter

    @ProvidePresenter
    fun providePresenter(): MovieDetailPresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getString(MOVIE_ID).orEmpty()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentMovieDetailBinding.inflate(inflater, container, false).let {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        presenter.loadDetail(movieId)
        binding.root
    }

    override fun showDetail(details: Title) {
        with(binding) {
            Glide.with(requireContext())
                .load(details.image)
                .into(ivMoviePoster)
            tvMovieTitle.text = "${details.fullTitle}"
            tvYear.text = "${tvYear.text} ${details.year}"
            tvDirector.text = "${tvDirector.text} ${details.director}"
            tvRating.text = "${tvRating.text} ${details.rating}"
            tvPlot.text = "${tvPlot.text} ${details.plot}"

            detailContainer.visibility = View.VISIBLE
        }
    }

    override fun showProgressbar() {
        binding.progrssbar.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        binding.progrssbar.visibility = View.GONE
    }

    override fun showError(e: Throwable) {
        Snackbar.make(binding.root, e.message.orEmpty(), Snackbar.LENGTH_SHORT).show()
    }
}