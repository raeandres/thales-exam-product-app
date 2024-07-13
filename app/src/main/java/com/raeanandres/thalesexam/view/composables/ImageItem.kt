package com.raeanandres.thalesexam.view.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.raeanandres.thalesexam.R

@Composable
fun ImageItem(imageUrl: String,
              contentDesc: String,) {
    AsyncImage(
        model = imageUrl,
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        error = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = contentDesc)
}