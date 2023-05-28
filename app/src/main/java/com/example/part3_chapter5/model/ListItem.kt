package com.example.part3_chapter5.model

import java.util.Date

interface ListItem {

    val thumbnailUrl: String
    val dateTime: Date
    val isFavorite: Boolean
}