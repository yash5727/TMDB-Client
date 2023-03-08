package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.useCase.GetMoviesUseCase
import com.example.tmdbclient.domain.useCase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {
    fun getMovies() = liveData {
        val movies = getMoviesUseCase.execute()
        emit(movies)
    }
    fun updateMovies() = liveData {
        val movies = updateMoviesUseCase.execute()
        emit(movies)
    }
}