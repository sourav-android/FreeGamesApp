package com.android.freegamesapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class FreeGamesDto(
    
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
    
    @SerializedName("developer")
    val developer: String,
    @SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("platform")
    val platform: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("release_date")
    val releaseDate: String,
    
    
)