package com.android.freegamesapp.domain.model

import com.google.gson.annotations.SerializedName

data class FreeGamesModel (
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("game_url")
    val gameUrl: String,
    @SerializedName("short_description")
    val shortDescription: String,
)