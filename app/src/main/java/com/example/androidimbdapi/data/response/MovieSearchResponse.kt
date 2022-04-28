package com.example.androidimbdapi.data.response

data class MovieSearchResponse(
    val errorMessage: String,
    val expression: String,
    val results: List<Result>,
    val searchType: String
)