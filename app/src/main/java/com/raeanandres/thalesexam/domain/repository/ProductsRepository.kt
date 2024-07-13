package com.raeanandres.thalesexam.domain.repository

import androidx.lifecycle.LiveData
import com.raeanandres.thalesexam.domain.dao.ProductDAO
import com.raeanandres.thalesexam.model.Product
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val productDAO: ProductDAO) {

    val readAllData: LiveData<List<Product>> = productDAO.readAllProducts()

    suspend fun addProduct(product: Product) {
        productDAO.addProduct(product)
    }

    suspend fun updateProduct(product: Product){
        productDAO.updateProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        productDAO.deleteProduct(product)
    }
}