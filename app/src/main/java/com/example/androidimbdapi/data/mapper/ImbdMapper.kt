package com.example.androidimbdapi.data.mapper

import com.example.androidimbdapi.data.response.MovieSearchResponse
import com.example.androidimbdapi.domain.entity.MovieSearch
import com.example.androidimbdapi.domain.entity.SearchResult

class ImbdMapper {

    fun mapSearchMovieResponse(response: MovieSearchResponse): MovieSearch{
        val result = mutableListOf<SearchResult>()
        response.results.forEach { movie ->
            result.add(SearchResult(
                description = movie.description,
                id = movie.id,
                image = movie.image,
                resultType = movie.resultType,
                title = movie.title
            )
            )
        }
        return MovieSearch(result)
    }
}