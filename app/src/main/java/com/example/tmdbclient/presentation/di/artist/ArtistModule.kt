package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.domain.useCase.GetArtistsUseCase
import com.example.tmdbclient.domain.useCase.UpdateArtistsUseCase
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(
            getArtistsUseCase, updateArtistsUseCase
        )
    }
}