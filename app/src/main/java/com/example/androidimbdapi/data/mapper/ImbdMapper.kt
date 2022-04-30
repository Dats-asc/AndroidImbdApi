package com.example.androidimbdapi.data.mapper

import com.example.androidimbdapi.data.response.MovieSearchResponse
import com.example.androidimbdapi.data.response.TitleResponse
import com.example.androidimbdapi.domain.entity.MovieSearch
import com.example.androidimbdapi.domain.entity.SearchResult
import com.example.androidimbdapi.domain.entity.Title

class ImbdMapper {

    fun mapSearchMovieResponse(response: MovieSearchResponse): MovieSearch {
        val result = arrayListOf<SearchResult>()
        response.results.forEach { movie ->
            result.add(
                SearchResult(
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

    fun mapTitle(response: TitleResponse) = Title(
        id = response.id,
        title = response.title,
        fullTitle = response.fullTitle,
        year = response.year,
        image = response.image,
        releaseDate = response.releaseDate,
        plot = response.plot,
        director = response.directorList.first().name,
        writer = response.writerList.first().name,
        country = response.countryList.first().value,
        rating = response.imDbRating
    )
}