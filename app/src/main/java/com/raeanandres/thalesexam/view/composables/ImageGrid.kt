package com.raeanandres.thalesexam.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raeanandres.thalesexam.model.Product
import com.raeanandres.thalesexam.view.ImageItem

@Composable
fun ImageGrid() {

    val products = listOf(
        Product(
            name = "Product 1",
            price = 10.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 2",
            price = 20.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 3",
            price = 30.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 4",
            price = 40.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 5",
            price = 50.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),
        Product(
            name = "Product 6",
            price = 60.0,
            type = "Shampoo",
            picture = "https://static.beautytocare.com/cdn-cgi/image/width=1440,height=1200,f=auto/media/catalog/product//j/o/johnson-s-baby-bedtime-shampoo-500ml_1.jpg",
            desc = "Shampoo for kids"),


        )

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        modifier = Modifier.fillMaxSize()
    ) {
        items(products.size) { productId ->
            products[productId].desc?.let {
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                ) {
                    Column {
                        ImageItem(products[productId].picture, it)
                        products[productId].desc?.let { it1 -> Text(text = it1) }
                    }
                }
            }
        }
    }
}