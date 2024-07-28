package com.raeanandres.thalesexam.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String? = null,
    val name: String,
    val price: Double,
    val product_type: String,
    val picture: String, // url
    val description: String?
) {
    companion object {
        val init = Product(
            id = "",
            name = "",
            product_type = "",
            picture = "",
            price = 0.0,
            description = ""
        )
    }
}