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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raeanandres.thalesexam.view.ProductsViewModel
import kotlinx.coroutines.CoroutineScope


@Composable
fun AddProduct(productsVm: ProductsViewModel? = null, coroutineScope: CoroutineScope) {

    var imageUrl by remember {
        mutableStateOf("")
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
                    }
                )
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
            ,onClick = {
            /*TODO*/
                // call api to save
            }) {
            Text(text = "Add Item")
        }

    }

//    val item = Product(name = name, type = type, picture = image, price = price, desc = description, createdDate = Date().toString())

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
}


@Preview
@Composable
fun PreviewAdd(){

    val coroutineScope = rememberCoroutineScope()

    AddProduct( coroutineScope = coroutineScope)

}