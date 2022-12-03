package com.noweshed.noweshedmisltest.data.repo.implementdatasource

import com.noweshed.noweshedmisltest.data.api.ApiService
import com.noweshed.noweshedmisltest.data.model.request.ProductReqById
import com.noweshed.noweshedmisltest.data.model.response.ProductItem
import com.noweshed.noweshedmisltest.data.model.response.ProductResponse
import com.noweshed.noweshedmisltest.data.repo.datasource.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by noweshedakram on 3/12/22.
 */
class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun getAllProducts(secretCode: String): Response<ProductItem> {
        return apiService.getAllProducts(secretCode = secretCode)
    }

    override suspend fun getProductById(
        secretCode: String,
        itemId: Int
    ): Response<ProductResponse> {
        return apiService.getProductsById(
            secretCode = secretCode,
            productReqById = ProductReqById(id = itemId)
        )
    }
}