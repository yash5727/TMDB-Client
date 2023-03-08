package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.domain.useCase.GetArtistsUseCase
import com.example.tmdbclient.domain.useCase.GetMoviesUseCase
import com.example.tmdbclient.domain.useCase.UpdateArtistsUseCase
import com.example.tmdbclient.domain.useCase.UpdateMoviesUseCase
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(
            getMoviesUseCase, updateMoviesUseCase
        )
    }
}