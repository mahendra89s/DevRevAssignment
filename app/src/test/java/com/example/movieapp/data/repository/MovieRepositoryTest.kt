package com.example.movieapp.data.repository

import com.example.movieapp.data.mockdata.MockData
import com.example.movieapp.data.remote.datasource.MoviesDataSource
import com.example.movieapp.utils.DataResult
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class MovieRepositoryTest {
    private lateinit var moviesRepository: MoviesRepository

    private val movieDataSource = mockk<MoviesDataSource>()
    @Before
    fun setup(){
        moviesRepository = MoviesRepositoryImpl(movieDataSource)
    }

    @Test
    fun `Given valid movieId when calling fetchMovieDetails then should get success response`() = runTest {
        coEvery {
            movieDataSource.fetchMovieDetail(any())
        }.answers{
            DataResult.Success(MockData.getMovieDetail())
        }
        val result = moviesRepository.fetchMovieDetail("1")
        Assert.assertEquals(true, result is DataResult.Success)
    }
    @Test
    fun `Given valid movieId when calling fetchMovieDetails then should get error response`() = runTest {
        coEvery {
            movieDataSource.fetchMovieDetail(any())
        }.answers{
            DataResult.Error("Error")
        }
        val result = moviesRepository.fetchMovieDetail("1")
        Assert.assertEquals(true, result is DataResult.Error)
    }
}