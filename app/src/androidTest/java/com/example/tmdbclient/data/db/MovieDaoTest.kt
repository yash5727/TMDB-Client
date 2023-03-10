package com.example.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.tmdbclient.data.model.movie.Movie
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieDaoTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieDao: MovieDao
    private lateinit var tmdbDatabase: TMDBDatabase

    @Before
    fun setUp() {
        tmdbDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        movieDao = tmdbDatabase.movieDao()
    }

    @After
    fun tearDown() {
        tmdbDatabase.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1,"overview1","posterpath1","date1","title1"),
            Movie(2,"overview2","posterpath2","date2","title2"),
            Movie(3,"overview3","posterpath3","date3","title3")
        )
        movieDao.saveMovies(movies)
        val allMovies = movieDao.getMovies()
        assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1,"overview1","posterpath1","date1","title1"),
            Movie(2,"overview2","posterpath2","date2","title2"),
            Movie(3,"overview3","posterpath3","date3","title3")
        )
        movieDao.saveMovies(movies)
        movieDao.deleteAllMovies()
        val moviesResult = movieDao.getMovies()
        assertThat(moviesResult).isEmpty()
    }
}