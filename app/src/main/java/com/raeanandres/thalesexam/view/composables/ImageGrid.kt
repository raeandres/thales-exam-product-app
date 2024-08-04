package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raeanandres.thalesexam.model.Product
import com.raeanandres.thalesexam.model.TaskType
import com.raeanandres.thalesexam.view.ProductsViewModel
import kotlinx.coroutines.launch

@Composable
fun ImageGrid(
    sheetStatus : MutableState<Boolean>,
    modifier: Modifier,
    productList: List<Product>,
    productVm: ProductsViewModel,
) {

    val coroutineScope = rememberCoroutineScope()

    var currentSortOrder by remember { mutableStateOf<SortOrder>(SortOrder.Price) }

    val sortedProducts = when (currentSortOrder) {
        SortOrder.Price -> productList.sortedBy { it.price }
        SortOrder.Type -> productList.sortedBy { it.product_type }
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
        modifier = modifier
    ) {

        items(sortedProducts) { product ->
            product.description?.let { desc ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                ) {
                    Column {
                        ImageItem(product.picture, desc)
                        Text(text = product.name, fontSize = 14.sp)
                        Text(text = product.product_type, fontSize = 14.sp)
                        Text(text = product.price.toString(), fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(2.dp))
                        Button(
                            onClick = {
                                productVm.setId(product.id ?: "")
                                productVm.setProductName(product.name)
                                productVm.setProductType(product.product_type)
                                productVm.setProductPrice(product.price.toString())
                                productVm.setUrl(product.picture)

                                sheetStatus.value = true
                                productVm.setTaskType(TaskType.EditProduct)
                        }) {
                            Text("Edit")
                        }
                    }
                }
            }
        }
    }
}