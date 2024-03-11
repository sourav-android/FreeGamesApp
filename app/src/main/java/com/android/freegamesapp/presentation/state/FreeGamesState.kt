package com.android.freegamesapp.presentation.state

import com.android.freegamesapp.domain.model.FreeGamesModel

data class FreeGamesState  (
    val freeGamesModel : List<FreeGamesModel>? = emptyList(),
    val errorMsg : String? = "",
    val isLoading : Boolean = false
)