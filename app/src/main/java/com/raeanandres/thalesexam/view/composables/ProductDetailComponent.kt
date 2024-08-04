package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.raeanandres.thalesexam.model.TaskType
import com.raeanandres.thalesexam.view.ProductsViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun ProductDetail(productsVm: ProductsViewModel, coroutineScope: CoroutineScope) {

    var imageUrl by remember {
        if (productsVm.taskType.value == TaskType.EditProduct) {
            mutableStateOf(productsVm.productImageUrl.value!!)
        } else {
            mutableStateOf("")
        }
    }

    Column {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
            Column( modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(horizontal = 10.dp))  {
                ImageItem(imageUrl, "")
            }
            Column (modifier = Modifier.fillMaxWidth()) {
                ItemDetailsField(
                    imageUrl = {
                        imageUrl = it
                    }, productsVm
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            ,onClick = {
                // call api to save
                when (productsVm.taskType.value) {
                    TaskType.AddProduct -> {
                        productsVm.addProduct()
                    }
                    TaskType.EditProduct -> {
                        productsVm.updateProduct()
                    }

                    null -> TODO()
                }
            }) {
            Text(color = Color.White,
                text = if ( productsVm.taskType.value == TaskType.EditProduct) "Update Item" else "Add Item")
        }
        Spacer(modifier = Modifier.height(30.dp))

    }
}