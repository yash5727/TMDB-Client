package com.example.tmdbclient.presentation.di.tvShow

import com.example.tmdbclient.domain.useCase.*
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import com.example.tmdbclient.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class TvShowModule {
    @ActivityScoped
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(
            getTvShowsUseCase, updateTvShowsUseCase
        )
    }
}