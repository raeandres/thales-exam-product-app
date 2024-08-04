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
   
    val itemList by productVm.fetchAllProducts.observeAsState(listOf())
    var filteredList by remember { mutableStateOf(itemList) }

    LaunchedEffect(itemList) {
        filteredList = itemList
    }

    fun onSearch(query: String) {
        filteredList = if (query.isEmpty()) {
            itemList
        } else {
            itemList.filter { it.name.contains(query, ignoreCase = true)
            }
        }
    }

    ScaffoldComponent(onSearch = ::onSearch, productVm, filteredList)
}