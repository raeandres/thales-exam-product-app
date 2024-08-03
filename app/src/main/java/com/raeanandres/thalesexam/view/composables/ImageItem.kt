package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.raeanandres.thalesexam.R

@Composable
fun ImageItem(imageUrl: String,
              contentDesc: String,) {
    AsyncImage(
        modifier = Modifier.size(140.dp),
        model = imageUrl,
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        error = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = contentDesc)
}