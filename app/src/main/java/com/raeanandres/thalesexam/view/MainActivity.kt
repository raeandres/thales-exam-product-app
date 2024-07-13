package com.raeanandres.thalesexam.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.raeanandres.thalesexam.R
import com.raeanandres.thalesexam.ui.theme.ThalesExamTheme
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
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThalesExamTheme {
//        ImageGrid()
    }
}

