package com.example.tmdbclient.presentation.tvShow

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.FragmentTvShowBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TvShowFragment : Fragment() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding: FragmentTvShowBinding
    private lateinit var adapter: TvShowAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(inflater)

        tvShowViewModel = ViewModelProvider(this,factory)[TvShowViewModel::class.java]

        initRecyclerView()
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater: MenuInflater = requireActivity().menuInflater
        inflater.inflate(R.menu.update,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun updateTvShows(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.updateTvShows()
        responseLiveData.observe(viewLifecycleOwner){
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else{
                binding.tvShowProgressBar.visibility = View.GONE
            }
        }
    }

    private fun initRecyclerView(){
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(viewLifecycleOwner){
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            } else{
                binding.tvShowProgressBar.visibility = View.GONE
                Toast.makeText(activity?.applicationContext,"No data available", Toast.LENGTH_SHORT).show()
            }
            Log.i("MYTAG",it.toString())
        }
    }
}