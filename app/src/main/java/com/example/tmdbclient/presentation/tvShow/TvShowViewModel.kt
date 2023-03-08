package com.example.tmdbclient.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.useCase.GetTvShowsUseCase
import com.example.tmdbclient.domain.useCase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {
    fun getTvShows() = liveData {
        val tvShows = getTvShowsUseCase.execute()
        emit(tvShows)
    }
    fun updateTvShows() = liveData {
        val tvShows = updateTvShowsUseCase.execute()
        emit(tvShows)
    }
}