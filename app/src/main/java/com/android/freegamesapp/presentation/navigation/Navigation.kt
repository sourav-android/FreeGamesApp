package com.android.freegamesapp.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.freegamesapp.presentation.components.GameScreen
import com.android.freegamesapp.presentation.navigation.screens.Screen
import com.android.freegamesapp.presentation.state.UiEffect
import com.android.freegamesapp.presentation.viewmodel.FreeGamesViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun Navigation(navController: NavHostController) {

    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = SnackbarHostState())
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.GameScreen.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(Screen.GameScreen.route) {
                val freeGameViewModel = hiltViewModel<FreeGamesViewModel>()
                val state = freeGameViewModel.freeGameState.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = true) {
                    freeGameViewModel.uiEffect.collectLatest { uiEffect ->
                        when (uiEffect) {
                            UiEffect.NavigationDetailsScreen -> {
                                TODO()
                            }

                            is UiEffect.ShowSnackBar -> {
                                launch {
                                    snackBarHostState.showSnackbar(uiEffect.msg, duration = SnackbarDuration.Long)
                                }
                            }
                        }
                    }
                }
                GameScreen(freeGameState = state.value, modifier = Modifier)
            }

        }

    }

    /*Scaffold(snackbarHost =
    {
        SnackbarHost(hostState = snackBarHostState)
    }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.GameScreen.route,
            modifier = Modifier.padding(it)
        ) {

            composable(Screen.GameScreen.route) {
                val freeGameViewModel = hiltViewModel<FreeGamesViewModel>()
                val state = freeGameViewModel.freeGameState.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = true) {
                    freeGameViewModel.uiEffect.collectLatest { uiEffect ->
                        when (uiEffect) {

                            is UiEffect.ShowSnackBar -> {
                                launch {
                                    snackBarHostState.showSnackbar(uiEffect.msg, duration = SnackbarDuration.Long)
                                }
                            }

                            UiEffect.NavigationDetailsScreen -> {

                            }
                        }
                    }
                }
                GameScreen(freeGameState = state.value, modifier = Modifier)
            }

        }
    }*/

}