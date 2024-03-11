package com.android.freegamesapp.data.repository

import com.android.freegamesapp.core.common.Resource
import com.android.freegamesapp.data.remote.FreeGamesApi
import com.android.freegamesapp.data.remote.mapper.toDomainFreeGamesModel
import com.android.freegamesapp.domain.model.FreeGamesModel
import com.android.freegamesapp.domain.repository.FreeGamesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FreeGamesRepositoryImpl (

    private val freeGamesApi: FreeGamesApi,
) : FreeGamesRepository {

    override fun getFreeGames(): Flow<Resource<List<FreeGamesModel>>> = flow {
        emit(Resource.Loading())
        val result = freeGamesApi.getFreeGames().map {
            it.toDomainFreeGamesModel()
        }
        emit(Resource.Success(result))

    }.flowOn(Dispatchers.IO)
        .catch {
            emit(Resource.Error(it.message.toString()))
        }

}