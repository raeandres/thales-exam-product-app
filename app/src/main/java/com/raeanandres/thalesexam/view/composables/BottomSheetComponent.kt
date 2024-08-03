package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetComponent(sheetState: SheetState, sheetStatus : MutableState<Boolean>){
    if (sheetStatus.value) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(0.5f),
            sheetState = sheetState,
            onDismissRequest = {
                sheetStatus.value = false
            }) {
            Column {
                Image(
                    modifier = Modifier.fillMaxWidth(), alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
            }
        }
    }

}