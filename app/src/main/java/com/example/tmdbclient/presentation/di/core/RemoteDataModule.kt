package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDatasource
import com.example.tmdbclient.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDatasource
import com.example.tmdbclient.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }
    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource{
        return ArtistRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }
    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, BuildConfig.API_KEY
        )
    }
}