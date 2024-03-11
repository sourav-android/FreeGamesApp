package com.android.freegamesapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.android.freegamesapp.domain.model.FreeGamesModel

@Composable
fun FreeGameItem(modifier: Modifier, freeGamesModel: FreeGamesModel) {

    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = freeGamesModel.thumbnail,
                contentDescription = "",
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = freeGamesModel.title, fontWeight = FontWeight.Bold)
            Text(text = freeGamesModel.shortDescription)

        }

    }
}