package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onSearch: (String) -> Unit) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }

    TopAppBar(
        title = {
            TextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    onSearch(it.text)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Search") }
            )
        }
    )
}
