package com.example.part3_chapter5.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class VideoListResponse(
    val documents : List<VideoItem>
)
data class VideoItem(
    @SerializedName("thumbnail") override val thumbnailUrl: String,
    @SerializedName("title") val title : String,
    @SerializedName("play_time") val playTime : Int,
    @SerializedName("author") val author : String,
    @SerializedName("datetime") override val dateTime: Date,
    override val isFavorite: Boolean = false

) : ListItem
