package com.example.part3_chapter5.list

import com.example.part3_chapter5.model.ListItem

interface ItemHandler {
    fun onClickFavorite(item: ListItem)
}