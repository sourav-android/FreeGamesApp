package com.android.freegamesapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.freegamesapp.presentation.state.FreeGamesState

@Composable
fun GameScreen(freeGameState: FreeGamesState, modifier: Modifier) {

    if (freeGameState.freeGamesModel?.isNotEmpty()!!){
        LazyColumn {
            items(freeGameState.freeGamesModel){
                FreeGameItem(modifier, it)
            }
        }
    } else if (freeGameState.isLoading){
        Box(modifier = modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
        }
    }
}