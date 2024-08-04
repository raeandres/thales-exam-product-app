package com.raeanandres.thalesexam.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raeanandres.thalesexam.domain.repository.ProductsRepository
import com.raeanandres.thalesexam.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repo: ProductsRepository
) : ViewModel() {

    private var _fetchAllProducts: MutableLiveData<List<Product>> = MutableLiveData()
    val fetchAllProducts : LiveData<List<Product>> get() = _fetchAllProducts


    fun fetchProducts() =  repo.fetchAllProductsFromRemote(onSuccess = {
        _fetchAllProducts.postValue(it)
    }, onError = {
        // implement error handling
    })

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
            val isUpdated = repo.updateProduct(product)
            if (isUpdated) {
                fetchProducts()
            }
        }
    }
}