package com.raeanandres.thalesexam.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raeanandres.thalesexam.domain.dao.ProductDAO
import com.raeanandres.thalesexam.domain.entity.Product
import com.raeanandres.thalesexam.domain.remote.RemoteApi
import io.ktor.http.parameters
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

    suspend fun filterMapStoredDataWithRemote(
        remoteData: List<com.raeanandres.thalesexam.model.Product>,
        localData: LiveData<List<Product>>){
    // check both remote and local data source to avoid storing duplicate entries to local storage
         remoteData.map {
             val mapToLocalDataType = Product(
                name = it.name,
                type = it.product_type,
                picture = it.picture,
                price = it.price,
                desc = it.description ?: "",
                createdDate = Date().toString())

             // check if there are remote data already existing in the local db
             if (!localData.value!!.contains(mapToLocalDataType)) {
                 // add items that are unique
                 CoroutineScope(Dispatchers.IO).launch {
                     productDAO.addProduct(mapToLocalDataType)
                 }
             }
        }
    }

    suspend fun addProduct(product: Product): Boolean {
        // call API first
       return remoteApi.addProduct(
            com.raeanandres.thalesexam.model.Product(
                name = product.name,
                product_type = product.type,
                picture = product.picture,
                price = product.price,
                description = product.desc,
            )
        )
    }

    suspend fun updateProduct(product: Product){
        productDAO.updateProduct(product)
    }

    suspend fun deleteProduct(product: Product){
        productDAO.deleteProduct(product)
    }
}