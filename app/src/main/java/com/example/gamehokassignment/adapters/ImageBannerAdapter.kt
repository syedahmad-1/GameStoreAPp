package com.example.gamehokassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gamehokassignment.databinding.ImageItemBinding
import com.example.gamehokassignment.models.ImageItem

class ImageBannerAdapter() : ListAdapter<ImageItem, ImageBannerAdapter.ImageBannerViewHolder>(
    COMPARATOR) {

    inner class ImageBannerViewHolder(val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageBannerViewHolder {
        return ImageBannerViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageBannerViewHolder, position: Int) {
        holder.binding.apply {
            val imageItem = getItem(position)
            imageView.load(imageItem.url)
        }
    }

    companion object{
        val COMPARATOR = object:DiffUtil.ItemCallback<ImageItem>(){
            override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
                return oldItem == newItem
            }

        }
    }


}