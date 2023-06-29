package com.example.mybottomnavapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mybottomnavapp.R

class EpisodeAdapter(private val episodeList: List<String>) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    inner class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val episodeNameTextView: TextView = itemView.findViewById(R.id.episodeNameTextView)

        init {
            // Set click listener on the item view
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val episode = episodeList[position]
                    val episodeNumber = getEpisodeNumberFromUrl(episode)

                    // Handle click event for the episode item
                    // Example: Navigate to episode details or perform an action
                    val context = itemView.context
                    Toast.makeText(context, "Clicked on Episode $episodeNumber", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.episode_item, parent, false)
        return EpisodeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episodeUrl = episodeList[position]
        val episodeNumber = getEpisodeNumberFromUrl(episodeUrl)

        holder.episodeNameTextView.text = "Episode $episodeNumber"
        holder.itemView.setOnClickListener {
            // Handle click event for the episode item
            // Example: Navigate to episode details or perform an action
            val context = holder.itemView.context
            Toast.makeText(context, "Clicked on Episode $episodeNumber", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getEpisodeNumberFromUrl(episodeUrl: String): String {
        // Extract the episode number from the URL
        val episodeNumber = episodeUrl.substringAfterLast("/").substringBeforeLast("/")
        return episodeNumber
    }


    override fun getItemCount(): Int {
        return episodeList.size
    }
}
