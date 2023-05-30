package com.example.part3_chapter5.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.part3_chapter5.databinding.ItemImageBinding
import com.example.part3_chapter5.list.ItemHandler
import com.example.part3_chapter5.model.ImageItem
import com.example.part3_chapter5.model.ListItem

class ImageItemViewHolder(
    private val binding: ItemImageBinding,
    private val itemHandler: ItemHandler? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem) {
        item as ImageItem
        binding.item = item
        binding.handler = itemHandler
    }
}