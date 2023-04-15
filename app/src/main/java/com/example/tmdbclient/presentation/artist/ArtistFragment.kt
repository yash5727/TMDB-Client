package com.example.tmdbclient.presentation.artist

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.FragmentArtistBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistFragment : Fragment() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: FragmentArtistBinding
    private lateinit var adapter: ArtistAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtistBinding.inflate(inflater)

        artistViewModel = ViewModelProvider(this,factory)[ArtistViewModel::class.java]

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
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun updateArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.updateArtists()
        responseLiveData.observe(viewLifecycleOwner){
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else{
                binding.artistProgressBar.visibility = View.GONE
            }
        }
    }

    private fun initRecyclerView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(activity?.applicationContext)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(viewLifecycleOwner){
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            } else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(activity?.applicationContext,"No data available", Toast.LENGTH_SHORT).show()
            }
            Log.i("MYTAG",it.toString())
        }
    }
}