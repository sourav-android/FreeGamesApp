package com.android.freegamesapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.freegamesapp.core.common.Resource
import com.android.freegamesapp.domain.usecase.FreeGamesUseCase
import com.android.freegamesapp.presentation.state.FreeGamesState
import com.android.freegamesapp.presentation.state.UiEffect
import com.android.freegamesapp.presentation.state.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FreeGamesViewModel @Inject constructor(
    private val freeGamesUseCase: FreeGamesUseCase,
) : ViewModel() {

    private val _freeGameState = MutableStateFlow(FreeGamesState())

    val freeGameState : StateFlow<FreeGamesState>
        get() = _freeGameState

    private val _uiEffect = MutableSharedFlow<UiEffect>()

    val uiEffect: SharedFlow<UiEffect>
        get() = _uiEffect.asSharedFlow()

    init {
        getAllGames()
    }


    private fun getAllGames() = freeGamesUseCase().onEach {
        when(it) {
            is Resource.Error -> {
                _freeGameState.value = FreeGamesState().copy(errorMsg = it.msg.toString())
                _uiEffect.emit(UiEffect.ShowSnackBar(it.msg.toString()))
            }
            is Resource.Loading -> {
                _freeGameState.value = FreeGamesState().copy(isLoading = true)
            }
            is Resource.Success -> {
                _freeGameState.value = FreeGamesState().copy(freeGamesModel =it.data)
            }
        }
    }.launchIn(viewModelScope)

    fun onEvent(uiEvent: UiEvent) {
        when(uiEvent) {
            UiEvent.NavigateToDetailsScreen -> {

            }
        }
    }

}