package com.example.gamehokassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gamehokassignment.databinding.TournamentItemBinding
import com.example.gamehokassignment.models.TournamentItem

class TournamentsAdapter() : ListAdapter<TournamentItem, TournamentsAdapter.TournamentsViewHolder>(
    COMPARATOR
) {

    inner class TournamentsViewHolder(val binding: TournamentItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentsViewHolder {
        return TournamentsViewHolder(
            TournamentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TournamentsViewHolder, position: Int) {
        holder.binding.apply {
            val tournamentItem = getItem(position)
            gameTv.text = tournamentItem.name
            gameIv.load(tournamentItem.image)
        }
    }


    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<TournamentItem>() {
            override fun areItemsTheSame(
                oldItem: TournamentItem,
                newItem: TournamentItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TournamentItem,
                newItem: TournamentItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}