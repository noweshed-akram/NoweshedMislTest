package com.noweshed.noweshedmisltest.data.repo.datasource

import com.noweshed.noweshedmisltest.data.model.response.ProductItem
import com.noweshed.noweshedmisltest.data.model.response.ProductResponse
import retrofit2.Response

/**
 * Created by noweshedakram on 3/12/22.
 */
interface RemoteDataSource {

    suspend fun getAllProducts(secretCode: String): Response<ProductItem>

    suspend fun getProductById(secretCode: String, itemId: Int): Response<ProductResponse>

}