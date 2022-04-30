package com.example.androidimbdapi.domain.entity

data class Title(
    val id: String,
    val title: String,
    val fullTitle: String,
    val year: String,
    val image: String,
    val releaseDate: String,
    val plot: String,
    val director: String,
    val country: String,
    val writer: String,
    val rating: String
)
