package com.example.mybottomnavapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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
        episodeAdapter = EpisodeAdapter(emptyList()) { position ->
            val episode = episodeAdapter.getEpisodeAtPosition(position)
            handleEpisodeClicked(episode)
        }
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

    private fun handleEpisodeClicked(episode: String) {

        val context = requireContext()
        val episodeNumber = getEpisodeNumberFromUrl(episode)
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(episode)
        startActivity(intent)

        Toast.makeText(context, "Clicked on Episode $episodeNumber", Toast.LENGTH_SHORT).show()
    }

    private fun getEpisodeNumberFromUrl(episodeUrl: String): String {
        // Extract the episode number from the URL
        val episodeNumber = episodeUrl.substringAfterLast("/").substringBeforeLast("/")
        return episodeNumber
    }
}

class EpisodeAdapter(
    private var episodeList: List<String>,
    private val onItemClicked: (position: Int) -> Unit
) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    inner class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val episodeNameTextView: TextView = itemView.findViewById(R.id.episodeNameTextView)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            onItemClicked(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.episode_item, parent, false)
        return EpisodeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodeList[position]
        val episodeNumber = getEpisodeNumber(episode)
        holder.episodeNameTextView.text = episodeNumber
    }

    private fun getEpisodeNumber(episode: String): String {
        // Extract the episode number from the episode string
        val episodeParts = episode.split("/")
        return if (episodeParts.size >= 3) {
            val episodeNumber = episodeParts[episodeParts.size - 1]
            "Episode $episodeNumber"
        } else {
            // Return a default value if the episode string is not in the expected format
            "Unknown Episode"
        }
    }


    override fun getItemCount(): Int {
        return episodeList.size
    }

    fun updateEpisodes(newEpisodes: List<String>) {
        episodeList = newEpisodes
        notifyDataSetChanged()
    }

    fun getEpisodeAtPosition(position: Int): String {
        return episodeList[position]
    }
}
