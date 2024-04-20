package com.example.movieapp.domain

import androidx.paging.PagingData
import com.example.movieapp.data.remote.model.Movie
import com.example.movieapp.data.repository.LatestPopularMovieRepository
import com.example.movieapp.domain.usecase.FetchPopularMoviesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class FetchPopularMoviesUseCaseTest {
    private lateinit var fetchPopularMoviesUseCase: FetchPopularMoviesUseCase
    private val latestPopularMovieRepository = mockk<LatestPopularMovieRepository>()

    @Before
    fun setup(){
        fetchPopularMoviesUseCase = FetchPopularMoviesUseCase(latestPopularMovieRepository)
    }

    @Test
    fun `Given FetchLatestMoviesUseCase then should get success response`() = runTest {
        val expected = PagingData.empty<Movie>()
        coEvery {
            latestPopularMovieRepository.fetchPopularMovie()
        }.answers{
            flow {
                emit(expected)
            }
        }
        val result = fetchPopularMoviesUseCase.invoke().first()
        Assert.assertEquals(expected, result)
    }
}