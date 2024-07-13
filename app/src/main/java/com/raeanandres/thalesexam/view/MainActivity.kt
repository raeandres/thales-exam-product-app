package com.raeanandres.thalesexam.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.raeanandres.thalesexam.R
import com.raeanandres.thalesexam.model.Product
import com.raeanandres.thalesexam.ui.theme.ThalesExamTheme
import com.raeanandres.thalesexam.view.composables.ImageGrid
import com.raeanandres.thalesexam.view.composables.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val productVm: ProductsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThalesExamTheme {
                MainScreen(productVm)
//                ImageGrid()
            }
        }
    }
}



@Composable
fun ImageItem(imageUrl: String,
              contentDesc: String,) {
    AsyncImage(
        model = imageUrl,
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        error = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = contentDesc)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThalesExamTheme {
        ImageGrid()
    }
}

