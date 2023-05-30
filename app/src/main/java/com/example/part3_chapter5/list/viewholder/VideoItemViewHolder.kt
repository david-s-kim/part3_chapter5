package com.example.part3_chapter5.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.part3_chapter5.databinding.ItemVideoBinding
import com.example.part3_chapter5.list.ItemHandler
import com.example.part3_chapter5.model.ListItem
import com.example.part3_chapter5.model.VideoItem

class VideoItemViewHolder(
    private val binding: ItemVideoBinding,
    private val itemHandler: ItemHandler? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem) {
        item as VideoItem
        binding.item = item
        binding.handler = itemHandler
    }

}