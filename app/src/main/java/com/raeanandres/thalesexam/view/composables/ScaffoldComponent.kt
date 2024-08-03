package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raeanandres.thalesexam.model.Product
import com.raeanandres.thalesexam.view.ProductsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComponent(onSearch: (query: String) -> Unit, productVm: ProductsViewModel, filteredList: List<Product>) {

    val sheetState = rememberModalBottomSheetState()
    val sheetStatus  = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = { TopBar(onSearch = onSearch) },
        content = { paddingValues ->
            Column(modifier = Modifier
                .padding(paddingValues)
                .padding(14.dp)) {
                ImageGrid(modifier = Modifier.fillMaxSize(), productList = filteredList, productVm = productVm)
                BottomSheetComponent(sheetState, sheetStatus)
            }
        },
        bottomBar = {
            BottomAppBar {
                Footer(sheetStatus)
            }
        }
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Footer(sheetStatus: MutableState<Boolean>){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {

            sheetStatus.value = true


//                       val item = Product(name = name, type = type, picture = image, price = price, desc = description, createdDate = Date().toString())

            // Mock item
//                       val item = Product(
//                           name = "Breeze Liquid Detergent - Colour Care",
//                           type = "Household",
//                           picture = "https://media.nedigital.sg/fairprice/fpol/media/images/product/XL/13026943_XL1_20220914.jpg?w=1200&q=70",
//                           price = 12.74,
//                           desc = "Breeze Liquid Detergent - Colour Care 3X tough stains removal, *based on internal lab test vs ordinary detergent powder",
//                           createdDate = Date().toString()
//                       )
//                       coroutineScope.launch {
//                           if (item.name.isNotEmpty() or item.picture.isNotEmpty()) productVm.addProduct(item)
//                       }
        }) {
            Text("Add Item")
        }
    }
}