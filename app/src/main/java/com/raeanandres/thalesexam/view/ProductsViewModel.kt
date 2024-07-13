package com.raeanandres.thalesexam.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raeanandres.thalesexam.domain.ProductsDb
import com.raeanandres.thalesexam.domain.repository.ProductsRepository
import com.raeanandres.thalesexam.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repo: ProductsRepository
) : ViewModel() {

    val readAllProducts : LiveData<List<Product>> = repo.readAllData

    fun addProduct(product: Product) {
        viewModelScope.launch (Dispatchers.IO) {
            repo.addProduct(product)
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