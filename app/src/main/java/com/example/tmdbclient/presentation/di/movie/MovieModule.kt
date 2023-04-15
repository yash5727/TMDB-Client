package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.domain.useCase.GetArtistsUseCase
import com.example.tmdbclient.domain.useCase.GetMoviesUseCase
import com.example.tmdbclient.domain.useCase.UpdateArtistsUseCase
import com.example.tmdbclient.domain.useCase.UpdateMoviesUseCase
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MovieModule {
    @ActivityScoped
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