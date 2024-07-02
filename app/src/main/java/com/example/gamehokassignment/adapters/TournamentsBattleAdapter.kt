package com.example.gamehokassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gamehokassignment.databinding.BattleItemBinding
import com.example.gamehokassignment.models.TournamentsBattle

class TournamentsBattleAdapter(private val onClick:(TournamentsBattle)->Unit):
    ListAdapter<TournamentsBattle, TournamentsBattleAdapter.TournamentsBattleViewHolder>(COMPARATOR) {

    inner class TournamentsBattleViewHolder (val binding: BattleItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentsBattleViewHolder {
        return TournamentsBattleViewHolder(BattleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TournamentsBattleViewHolder, position: Int) {

        holder.binding.apply {
            val battleItem = getItem(position)

            root.setOnClickListener {
                onClick(battleItem)
            }
            tournamentTitleTv.text = battleItem.tournamentTitle
            dateTv.text = battleItem.date
            entryTv.text = battleItem.entry
            teamSizeTv.text = battleItem.teamSize
            tournamentsDetailsTv.text = battleItem.tournamentDetails
            gameBackgroundIv.load(battleItem.tournamentImage)
            registrationStatusTv.text = battleItem.registrationStatus
            coinsAmountTv.text = battleItem.coinsAmount

        }
    }

    companion object{
        val COMPARATOR = object :DiffUtil.ItemCallback<TournamentsBattle>() {
            override fun areItemsTheSame(
                oldItem: TournamentsBattle,
                newItem: TournamentsBattle
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: TournamentsBattle,
                newItem: TournamentsBattle
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}