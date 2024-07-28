package com.raeanandres.thalesexam.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raeanandres.thalesexam.domain.dao.ProductDAO
import com.raeanandres.thalesexam.domain.entity.Product
import com.raeanandres.thalesexam.domain.remote.RemoteApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val productDAO: ProductDAO) {

    private val remoteApi = RemoteApi()

    val readAllData: LiveData<List<Product>> = productDAO.readAllProducts()

    fun fetchAllProductsFromRemote() {
        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {
                // fetch from remote
                remoteApi.getAllProducts()
            }.onSuccess { products ->
                // store immediately to db
                products.map {
                    productDAO.addProduct(
                        Product(
                            name = it.name,
                            type = it.product_type,
                            picture = it.picture,
                            price = it.price,
                            desc = it.description ?: "",
                            createdDate = Date().toString()
                        )
                    )
                }

            }.onFailure { error ->
                // show error
            }
        }
    }

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