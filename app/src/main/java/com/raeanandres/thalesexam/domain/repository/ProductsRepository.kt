package com.raeanandres.thalesexam.domain.repository

import androidx.lifecycle.LiveData
import com.raeanandres.thalesexam.domain.remote.RemoteApi
import com.raeanandres.thalesexam.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductsRepository @Inject constructor() {

    private val remoteApi = RemoteApi()

    fun fetchAllProductsFromRemote(onSuccess: ( List<Product>) -> Unit, onError: (String) -> Unit)  {
        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {
                // fetch from remote
                remoteApi.getAllProducts()
            }.onSuccess { products ->
               onSuccess.invoke(products)
            }.onFailure { error ->
                // show error
                error.message?.let {
                    onError.invoke(it)
                }
            }
        }
    }

    suspend fun filterMapStoredDataWithRemote(
        remoteData: List<Product>,
        localData: LiveData<List<Product>>){
    // check both remote and local data source to avoid storing duplicate entries to local storage
         remoteData.map {
//             val mapToLocalDataType = Product(
//                name = it.name,
//                type = it.product_type,
//                picture = it.picture,
//                price = it.price,
//                desc = it.description ?: "",
//                createdDate = Date().toString())
//
//             // check if there are remote data already existing in the local db
//             if (!localData.value!!.contains(mapToLocalDataType)) {
//                 // add items that are unique
//                 CoroutineScope(Dispatchers.IO).launch {
////                     productDAO.addProduct(mapToLocalDataType)
//                 }
//             }
        }
    }

    suspend fun addProduct(product: Product): Boolean {
        // call API first
       return remoteApi.addProduct(
            Product(
                name = product.name,
                product_type = product.product_type,
                picture = product.picture,
                price = product.price,
                description = product.description,
            )
        )
    }

    suspend fun updateProduct(product: Product): Boolean{

        return remoteApi.updateProduct(product)
    }

    suspend fun deleteProduct(product: Product){
    }
}