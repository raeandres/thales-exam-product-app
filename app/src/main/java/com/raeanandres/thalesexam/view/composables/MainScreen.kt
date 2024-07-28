package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.raeanandres.thalesexam.domain.entity.Product
import com.raeanandres.thalesexam.view.ProductsViewModel
import kotlinx.coroutines.launch
import java.util.Date

@Composable
fun MainScreen(productVm: ProductsViewModel = viewModel()) {
    // just mock image
    val imageMock = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg"


    val itemList by productVm.readAllProducts.observeAsState(listOf())
    val coroutineScope = rememberCoroutineScope()

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
                        it.type.contains(query, ignoreCase = true) ||
                        it.price.toString().contains(query, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = { TopBar(onSearch = ::onSearch) },
        content = { paddingValues ->
            Column(modifier = Modifier
                .padding(paddingValues)
                .padding(14.dp)) {
                ImageGrid(productList = filteredList, productVm = productVm)
            }
        },
        bottomBar = {
            BottomAppBar {
               Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                   Button(onClick = {
//                       val item = Product(name = name, type = type, picture = image, price = price, desc = description, createdDate = Date().toString())

                       // Mock item
                       val item = Product(
                           name = "Breeze Liquid Detergent - Colour Care",
                           type = "Household",
                           picture = "https://media.nedigital.sg/fairprice/fpol/media/images/product/XL/13026943_XL1_20220914.jpg?w=1200&q=70",
                           price = 12.74,
                           desc = "Breeze Liquid Detergent - Colour Care 3X tough stains removal, *based on internal lab test vs ordinary detergent powder",
                           createdDate = Date().toString()
                       )
                       coroutineScope.launch {
                           if (item.name.isNotEmpty() or item.picture.isNotEmpty()) productVm.addProduct(item)
                       }
                   }) {
                       Text("Add Item")
                   }
               }
            }
        }
    )
}