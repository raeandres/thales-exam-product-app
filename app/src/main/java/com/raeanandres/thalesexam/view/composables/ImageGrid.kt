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
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raeanandres.thalesexam.domain.entity.Product
import com.raeanandres.thalesexam.view.ProductsViewModel
import kotlinx.coroutines.launch

@Composable
fun ImageGrid(productList: List<Product>, productVm: ProductsViewModel) {

    val coroutineScope = rememberCoroutineScope()

    var currentSortOrder by remember { mutableStateOf<SortOrder>(SortOrder.Price) }

    val sortedProducts = when (currentSortOrder) {
        SortOrder.Price -> productList.sortedBy { it.price }
        SortOrder.Type -> productList.sortedBy { it.type }
    }

    SortComponent(
        priceSort = { price ->
            currentSortOrder = currentSortOrder.sortBy(price)
        }, typeSort = { type ->
            currentSortOrder = currentSortOrder.sortBy(type)
        })

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

        items(sortedProducts) { product ->
            product.desc.let { description ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                ) {
                    Column {
                        ImageItem(product.picture, description)
                        Text(text = product.name, fontSize = 14.sp)
                        Text(text = product.type, fontSize = 14.sp)
                        Text(text = product.price.toString(), fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(2.dp))
                        Button(
                            onClick = {
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
}