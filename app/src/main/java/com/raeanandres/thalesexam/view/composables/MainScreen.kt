package com.raeanandres.thalesexam.view.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raeanandres.thalesexam.view.ProductsViewModel

@Composable
fun MainScreen(productVm: ProductsViewModel = viewModel()) {
    // just mock image
    val imageMock = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg"


    val itemList by productVm.fetchAllProducts.observeAsState(listOf())

    var name by remember { mutableStateOf("") }
    val type by remember { mutableStateOf("")}
    val image by remember { mutableStateOf(imageMock) } // update later
    val price by remember { mutableDoubleStateOf(0.0) }
    var description by remember { mutableStateOf("") }
    var filteredList by remember { mutableStateOf(itemList) }

    LaunchedEffect(itemList) {
        filteredList = itemList
    }

    fun onSearch(query: String) {
        filteredList = if (query.isEmpty()) {
            itemList
        } else {
            itemList.filter { it.name.contains(query, ignoreCase = true) ||
                        it.product_type.contains(query, ignoreCase = true) ||
                        it.price.toString().contains(query, ignoreCase = true)
            }
        }
    }

    ScaffoldComponent(onSearch = ::onSearch, productVm, filteredList)
}