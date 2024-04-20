package com.example.movieapp.data.mockdata

import com.example.movieapp.data.remote.model.MovieDetail

object MockData {

    fun getMovieDetail(): MovieDetail {
        return MovieDetail(
            adult = false,
            backdropPath = "",
            belongsToCollection = "",
            budget = 2,
            genres = listOf(),
            homepage = "",
            id = 12,
            imdbId = "",
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 2.0,
            posterPath = "",
            productionCompanies = listOf(),
            productionCountries = listOf(),
            releaseDate = "",
            revenue = 1,
            runtime = 2,
            spokenLanguages = listOf(),
            status = "",
            tagline = "",
            title = "",
            video = false,
            voteAverage = 1.0,
            voteCount = 2
        )
    }
}