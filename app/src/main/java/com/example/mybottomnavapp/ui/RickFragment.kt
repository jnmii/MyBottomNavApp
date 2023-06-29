package com.example.mybottomnavapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybottomnavapp.R
import com.example.mybottomnavapp.data.remote.ApiDetails
import com.example.mybottomnavapp.databinding.FragmentRickBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RickFragment : Fragment() {

    private lateinit var binding: FragmentRickBinding
    private lateinit var episodeAdapter: EpisodeAdapter
    private var characterCount = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRickBinding.inflate(inflater, container, false)

        // Set up the RecyclerView
        episodeAdapter = EpisodeAdapter(emptyList())
        binding.episodeRecyclerView.adapter = episodeAdapter
        binding.episodeRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        loadData()

        binding.nextCharacter.setOnClickListener {
            characterCount++
            loadData()
        }

        return binding.root
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = ApiDetails.rickClient.getRickCharacter(characterCount)
            binding.tvHome.text = result.name

            Glide.with(requireContext())
                .load(result.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.imageView)

            // Update the episode list in the adapter
            episodeAdapter.updateEpisodes(result.episode ?: emptyList())
        }
    }

    class EpisodeAdapter(private var episodeList: List<String>) :
        RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

        inner class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val episodeNameTextView: TextView = itemView.findViewById(R.id.episodeNameTextView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.episode_item, parent, false)
            return EpisodeViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
            val episode = episodeList[position]
            holder.episodeNameTextView.text = episode
        }

        override fun getItemCount(): Int {
            return episodeList.size
        }

        fun updateEpisodes(newEpisodes: List<String>) {
            episodeList = newEpisodes
            notifyDataSetChanged()
        }
    }
}
