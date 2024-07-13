package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raeanandres.thalesexam.domain.entity.Product
import com.raeanandres.thalesexam.view.ImageItem
import com.raeanandres.thalesexam.view.ProductsViewModel
import kotlinx.coroutines.launch

@Composable
fun ImageGrid(productList: List<Product>, productVm: ProductsViewModel) {

    val coroutineScope = rememberCoroutineScope()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        items(productList.size) { productIndex ->
            val product = productList[productIndex]
            product.desc.let { description ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                ) {
                    Column {
                        ImageItem(product.picture, description)
                        Text(text = description)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        coroutineScope.launch {
                            productVm.deleteProduct(product)
                        }
                    }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}