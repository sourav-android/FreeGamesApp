package com.android.freegamesapp.presentation.navigation.screens

sealed class Screen(val route: String) {
    data object GameScreen : Screen("game_screen")
}