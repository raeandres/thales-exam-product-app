package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raeanandres.thalesexam.domain.entity.Product
import com.raeanandres.thalesexam.view.ProductsViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(productVm: ProductsViewModel = viewModel()) {
    val itemList by productVm.readAllProducts.observeAsState(listOf())
    val coroutineScope = rememberCoroutineScope()

    var name by remember { mutableStateOf("") }
    val type by remember { mutableStateOf("")}
    val image by remember { mutableStateOf("") }
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
            itemList.filter {it.name.contains(query, ignoreCase = true)}
        }
    }

    Scaffold(
        topBar = { TopBar(onSearch = ::onSearch) }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .padding(16.dp)) {
            TextField(
                value = name,
                onValueChange = { name = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Name") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Description") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                val item = Product(name = name, type = type, picture = image, price = price, desc = description)
                coroutineScope.launch {
                    if (item.name.isNotEmpty() or item.picture.isNotEmpty()) productVm.addProduct(item)
                }
            }) {
                Text("Add Item")
            }
            Spacer(modifier = Modifier.height(16.dp))
            ImageGrid(productList = filteredList, productVm = productVm)
//            LazyColumn {
//                items(filteredList.size) { index ->
//                    Text(text = "${filteredList[index].name}: ${filteredList[index].desc}")
//                    Row {
//                        Button(onClick = { /* Update logic */ }) {
//                            Text("Update")
//                        }
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Button(onClick = {
//                            coroutineScope.launch {
//                                itemViewModel.deleteProduct(filteredList[index])
//                            }
//                        }) {
//                            Text("Delete")
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(8.dp))
//                }
//            }
        }
    }
}