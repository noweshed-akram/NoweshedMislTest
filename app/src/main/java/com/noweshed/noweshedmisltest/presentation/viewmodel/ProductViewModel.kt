package com.noweshed.noweshedmisltest.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.noweshed.noweshedmisltest.data.model.request.ProductReqById
import com.noweshed.noweshedmisltest.data.model.response.ProductItem
import com.noweshed.noweshedmisltest.data.model.response.ProductResponse
import com.noweshed.noweshedmisltest.data.util.Network.isNetworkAvailable
import com.noweshed.noweshedmisltest.data.util.Resource
import com.noweshed.noweshedmisltest.domain.usecase.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by noweshedakram on 3/12/22.
 */
@HiltViewModel
class ProductViewModel @Inject constructor(
    private val app: Application,
    private val productUseCase: ProductUseCase
) : AndroidViewModel(app) {

    val productList: MutableLiveData<Resource<ProductItem>> = MutableLiveData()

    val product: MutableLiveData<Resource<ProductResponse>> = MutableLiveData()

    fun getAllProducts(secretCode: String) = viewModelScope.launch(IO) {
        productList.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = productUseCase.getAllProducts(secretCode = secretCode)
                productList.postValue(apiResult)
            } else {
                productList.postValue(Resource.Error(message = "Internet isn't Available"))
            }
        } catch (e: Exception) {
            productList.postValue(Resource.Error(message = e.localizedMessage ?: "Unknown Error"))
        }
    }

    fun getProductById(secretCode: String, id: Int) = viewModelScope.launch(IO) {
        product.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = productUseCase.getProductById(secretCode = secretCode, itemId = id)
                product.postValue(apiResult)
            } else {
                product.postValue(Resource.Error(message = "Internet isn't Available"))
            }
        } catch (e: Exception) {
            product.postValue(Resource.Error(message = e.localizedMessage ?: "Unknown Error"))
        }
    }
}