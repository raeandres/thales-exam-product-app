package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

sealed class SortOrder{
    data object Price: SortOrder()
    data object Type: SortOrder()

    fun sortBy(sortOrder: SortOrder): SortOrder {
        return when (sortOrder) {
            is Price -> Price
            is Type -> Type
        }
    }
}



@Composable
fun SortComponent( priceSort: (SortOrder)-> Unit, typeSort: (SortOrder) -> Unit, ){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(intrinsicSize = IntrinsicSize.Min)){
        Text(text = "Sort by Price" ,
            color = Color.Black,
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.large)
                .padding(horizontal = 32.dp, vertical = 10.dp)
                .clickable { priceSort(SortOrder.Price) }
        )
        Spacer(modifier = Modifier.padding(all = 4.dp))
        Text(text = "Sort by Type" ,
            color = Color.Black,
            modifier = Modifier
                .border(width = 1.dp, color = Color.Black, shape = MaterialTheme.shapes.large)
                .padding(horizontal = 32.dp, vertical = 10.dp)
                .clickable { typeSort(SortOrder.Type) }
        )
    }
    
}