package com.raeanandres.thalesexam.model

data class Product(
    val name: String,
    val price: Double,
    val type: String,
    val picture: String, // url
    val desc: String?
)