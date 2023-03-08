package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.useCase.GetArtistsUseCase
import com.example.tmdbclient.domain.useCase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {
    fun getArtists() = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }
    fun updateArtists() = liveData {
        val artists = updateArtistsUseCase.execute()
        emit(artists)
    }
}