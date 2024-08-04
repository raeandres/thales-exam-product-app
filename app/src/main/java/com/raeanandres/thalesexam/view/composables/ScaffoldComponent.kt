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
import androidx.compose.runtime.rememberCoroutineScope
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
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { TopBar(onSearch = onSearch) },
        content = { paddingValues ->
            Column(modifier = Modifier
                .padding(paddingValues)
                .padding(14.dp)) {
                ImageGrid(
                    sheetStatus = sheetStatus,
                    modifier = Modifier.fillMaxSize(),
                    productList = filteredList,
                    productVm = productVm
                )
                BottomSheetComponent(sheetState, sheetStatus, coroutineScope, productVm)
            }
        },
        bottomBar = {
            BottomAppBar {
                Footer(sheetStatus)
            }
        }
    )
}

@Composable
fun Footer(sheetStatus: MutableState<Boolean>){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {
            sheetStatus.value = true
        }) {
            Text("Add Item")
        }
    }
}