package com.android.freegamesapp.presentation.state

sealed class UiEffect {
    class ShowSnackBar(val  msg : String) : UiEffect()
    data object NavigationDetailsScreen : UiEffect()
}