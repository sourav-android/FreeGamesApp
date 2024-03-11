package com.android.freegamesapp.presentation.state

sealed class UiEvent {
    data object NavigateToDetailsScreen : UiEvent()
}