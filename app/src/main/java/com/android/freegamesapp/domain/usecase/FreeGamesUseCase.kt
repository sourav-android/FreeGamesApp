package com.android.freegamesapp.domain.usecase

import com.android.freegamesapp.domain.repository.FreeGamesRepository

class FreeGamesUseCase (
    private val freeGamesRepository: FreeGamesRepository
) {

    operator fun invoke() = freeGamesRepository.getFreeGames()
}