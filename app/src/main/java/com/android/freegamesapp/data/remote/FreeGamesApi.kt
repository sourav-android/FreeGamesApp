package com.android.freegamesapp.data.remote

import com.android.freegamesapp.data.remote.dto.FreeGamesDto
import retrofit2.http.GET

interface FreeGamesApi {

    @GET("games")
    suspend fun getFreeGames()  : List<FreeGamesDto>
}