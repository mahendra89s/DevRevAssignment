package com.example.movieapp.domain

import androidx.paging.PagingData
import com.example.movieapp.data.remote.model.Movie
import com.example.movieapp.data.repository.LatestPopularMovieRepository
import com.example.movieapp.domain.usecase.FetchLatestMoviesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FetchLatestMoviesUseCaseTest {
    private lateinit var fetchLatestMoviesUseCase: FetchLatestMoviesUseCase
    private val latestPopularMovieRepository = mockk<LatestPopularMovieRepository>()

    @Before
    fun setup(){
        fetchLatestMoviesUseCase = FetchLatestMoviesUseCase(latestPopularMovieRepository)
    }

    @Test
    fun `Given FetchLatestMoviesUseCase then should get success response`() = runTest {
        val expected = PagingData.empty<Movie>()
        coEvery {
            latestPopularMovieRepository.fetchLatestMovie()
        }.answers{
            flow {
                emit(expected)
            }
        }
        val result = fetchLatestMoviesUseCase.invoke().first()
        Assert.assertEquals(expected, result)
    }
}