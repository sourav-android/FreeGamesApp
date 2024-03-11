package com.android.freegamesapp.data.remote.mapper

import com.android.freegamesapp.data.remote.dto.FreeGamesDto
import com.android.freegamesapp.domain.model.FreeGamesModel

fun FreeGamesDto.toDomainFreeGamesModel(): FreeGamesModel {
    return FreeGamesModel(id, thumbnail, title, gameUrl, shortDescription)
}