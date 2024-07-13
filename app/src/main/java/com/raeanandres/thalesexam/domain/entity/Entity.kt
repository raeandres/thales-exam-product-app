package com.raeanandres.thalesexam.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: String,
    val picture: String,
    val price: Double,
    val description: String
)