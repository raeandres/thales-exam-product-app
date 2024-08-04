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

    private var _productImageUrl : MutableLiveData<String> = MutableLiveData()

    private var _productNameText : MutableLiveData<String> = MutableLiveData()

    private var _productTypeText : MutableLiveData<String> = MutableLiveData()

    private var _productPriceText : MutableLiveData<String> = MutableLiveData()


    private var _isProductAdded : MutableLiveData<Boolean> = MutableLiveData()

    val isProductAdded : LiveData<Boolean> get()= _isProductAdded



    fun fetchProducts() =  repo.fetchAllProductsFromRemote(onSuccess = {
        _fetchAllProducts.postValue(it)
    }, onError = {
        // implement error handling
    })

    private fun isRequiredFieldsNotNull () : Boolean {
        return _productNameText.value != null &&
                _productNameText.value != null &&
                _productTypeText.value != null &&
                _productPriceText.value != null
    }

    fun addProduct() {
        viewModelScope.launch (Dispatchers.IO) {
            val product = Product(
                name = _productNameText.value ?: "",
                picture = _productNameText.value ?: "",
                product_type = _productTypeText.value ?: "",
                price = _productPriceText.value?.toDouble() ?: 0.0,
                description = ""
            )

            val isAdded = repo.addProduct(product)
            _isProductAdded.postValue(repo.addProduct(product))
            if (isAdded) {
                // fetch products from API=
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


    fun setUrl(url: String) {
        _productImageUrl.value = url
    }

    fun setProductName(productName: String) {
        _productNameText.value = productName
    }

    fun setProductType(productType: String) {
        _productTypeText.value = productType
    }

    fun setProductPrice(productPrice: String) {
        _productPriceText.value = productPrice
    }


}