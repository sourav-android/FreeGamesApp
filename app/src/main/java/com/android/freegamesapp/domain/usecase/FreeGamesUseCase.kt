package com.android.freegamesapp.domain.usecase

import com.android.freegamesapp.domain.repository.FreeGamesRepository
import javax.inject.Inject

class FreeGamesUseCase @Inject constructor(
    private val freeGamesRepository: FreeGamesRepository
) {

    operator fun invoke() = freeGamesRepository.getFreeGames()
}