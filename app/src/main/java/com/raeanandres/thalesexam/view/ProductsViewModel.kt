package com.raeanandres.thalesexam.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raeanandres.thalesexam.domain.entity.Product
import com.raeanandres.thalesexam.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repo: ProductsRepository
) : ViewModel() {

    val readAllProducts : LiveData<List<Product>> = repo.readAllData

    fun fetchProducts() = repo.fetchAllProductsFromRemote()

    fun addProduct(product: Product) {
        viewModelScope.launch (Dispatchers.IO) {
            val isAdded = repo.addProduct(product)
            if (isAdded) {
                // fetch products from API
                fetchProducts()
            }
        }
    }

    fun updateProduct(product: Product){
        viewModelScope.launch (Dispatchers.IO) {
            repo.updateProduct(product)
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch (Dispatchers.IO) {
            repo.deleteProduct(product)
        }
    }
}