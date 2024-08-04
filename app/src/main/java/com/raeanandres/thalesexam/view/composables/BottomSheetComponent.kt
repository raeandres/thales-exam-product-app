package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.raeanandres.thalesexam.R
import com.raeanandres.thalesexam.view.ProductsViewModel
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetComponent(sheetState: SheetState, sheetStatus : MutableState<Boolean>, coroutineScope: CoroutineScope, productsVm: ProductsViewModel){
    if (sheetStatus.value) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(0.5f),
            sheetState = sheetState,
            onDismissRequest = {
                sheetStatus.value = false
            }) {
           Box(modifier = Modifier.fillMaxSize()){
               AddProduct(productsVm = productsVm, coroutineScope = coroutineScope)
           }
        }
    }

}