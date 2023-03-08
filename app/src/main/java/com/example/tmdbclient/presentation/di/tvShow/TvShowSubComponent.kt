package com.example.tmdbclient.presentation.di.tvShow

import com.example.tmdbclient.presentation.tvShow.TvShowFragment
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowFragment: TvShowFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): TvShowSubComponent
    }
}