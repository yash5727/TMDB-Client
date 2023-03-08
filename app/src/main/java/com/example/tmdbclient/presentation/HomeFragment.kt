package com.example.tmdbclient.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.FragmentHomeBinding
import com.example.tmdbclient.presentation.artist.ArtistFragment
import com.example.tmdbclient.presentation.movie.MovieFragment
import com.example.tmdbclient.presentation.tvShow.TvShowFragment

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.movieButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.activityContainer,
                MovieFragment()
            )?.addToBackStack(null)?.commit()
        }
        binding.artistsButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.activityContainer,
                ArtistFragment()
            )?.addToBackStack(null)?.commit()        }
        binding.tvButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.activityContainer,
                TvShowFragment()
            )?.addToBackStack(null)?.commit()        }
        return binding.root
    }
}