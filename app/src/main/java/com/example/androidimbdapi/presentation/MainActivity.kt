package com.example.androidimbdapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.androidimbdapi.R
import com.example.androidimbdapi.databinding.ActivityMainBinding
import com.example.androidimbdapi.presentation.search.MovieSearchFragment
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatActivity
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : MvpAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().run {
            add(R.id.fragment_container_view, MovieSearchFragment())
            addToBackStack(null)
            commit()
        }
    }


}