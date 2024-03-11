package com.android.freegamesapp.domain.repository

import com.android.freegamesapp.core.common.Resource
import com.android.freegamesapp.domain.model.FreeGamesModel
import kotlinx.coroutines.flow.Flow

interface FreeGamesRepository {

    fun getFreeGames() : Flow<Resource<List<FreeGamesModel>>>
}