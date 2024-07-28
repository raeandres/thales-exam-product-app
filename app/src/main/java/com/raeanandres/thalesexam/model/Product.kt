package com.raeanandres.thalesexam.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val product_type: String,
    val picture: String, // url
    val description: String?
)