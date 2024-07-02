package com.example.gamehokassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gamehokassignment.databinding.PeopleToFollowItemBinding
import com.example.gamehokassignment.models.UserItem

class GamersAdapter: ListAdapter<UserItem, GamersAdapter.GamersViewHolder>(COMPARATOR) {


    inner class GamersViewHolder(val binding: PeopleToFollowItemBinding): RecyclerView.ViewHolder(binding.root)

    companion object{
        val COMPARATOR = object : DiffUtil.ItemCallback<UserItem>() {
            override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamersViewHolder {
        return GamersViewHolder(PeopleToFollowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GamersViewHolder, position: Int) {
        holder.binding.apply {
            val userItem = getItem(position)
            userNameTv.text = userItem.name
            userIv.load(userItem.image)

        }
    }
}