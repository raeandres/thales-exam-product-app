package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.raeanandres.thalesexam.view.ProductsViewModel

@Composable
fun ItemDetailsField(imageUrl: (String) -> Unit, productsViewModel: ProductsViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current

    var productImageUrl by remember {
        mutableStateOf("")
    }
    var productNameText by remember {
        mutableStateOf("")
    }
    var productTypeText by remember {
        mutableStateOf("")
    }
    var productPriceText by remember {
        mutableStateOf("")
    }


    Column {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .onFocusChanged {
                    if (it.isFocused) {
                        keyboardController?.hide()
                    }
                }
                .focusable(),
            keyboardActions = KeyboardActions(
                onDone = {
                    imageUrl.invoke(productImageUrl)
                    productsViewModel.setUrl(productImageUrl)
                    keyboardController?.hide()
                }
            ),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            value = productImageUrl,
            onValueChange = {
                    newText ->
                productImageUrl = newText
            },
            placeholder = { Text(
                text = "Image Url",
                color = Color.Gray
            )
            })

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .onFocusChanged {
                    if (it.isFocused) {
                        keyboardController?.hide()
                    }
                }
                .focusable(),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    productsViewModel.setProductName(productNameText)
                }
            ),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            value = productNameText,
            onValueChange = {
                    newText ->
                productNameText = newText
            }, placeholder = { Text(
                text = "Product Name",
                color = Color.Gray)
            })
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .onFocusChanged {
                    if (it.isFocused) {
                        keyboardController?.hide()
                    }
                }
                .focusable(),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    productsViewModel.setProductType(productTypeText)
                }
            ),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            value = productTypeText,
            onValueChange = {
                    newText ->
                productTypeText = newText
            }, textStyle = TextStyle(),
            placeholder = { Text(
                text = "Product Type",
                color = Color.Gray)
            })
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .onFocusChanged {
                    if (it.isFocused) {
                        keyboardController?.hide()
                    }
                }
                .focusable(),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    productsViewModel.setProductPrice(productPriceText)
                }
            ),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            value = productPriceText,
            onValueChange = {
                    newText ->
                productPriceText = newText
            }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(
                text = "Price",
                color = Color.Gray)
            })
    }
}