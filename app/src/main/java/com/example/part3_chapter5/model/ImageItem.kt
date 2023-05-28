package com.example.part3_chapter5.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ImageListResponse(
    val documents : List<ImageItem>
)

data class ImageItem(
    @SerializedName("thumbnail_url") override val thumbnailUrl: String,
    @SerializedName("collection") val collection : String,
    @SerializedName("display_sitename") val siteName : String,
    @SerializedName("doc_url") val docUrl : String,
    @SerializedName("datetime") override val dateTime: Date,
    override val isFavorite: Boolean

) : ListItem
