package com.noweshed.noweshedmisltest.domain.repo

import com.noweshed.noweshedmisltest.data.model.response.ProductItem
import com.noweshed.noweshedmisltest.data.model.response.ProductResponse
import com.noweshed.noweshedmisltest.data.util.Resource

/**
 * Created by noweshedakram on 3/12/22.
 */
interface ProductRepo {

    suspend fun getAllProducts(secretCode: String): Resource<ProductItem>

    suspend fun getProductById(secretCode: String, itemId: Int): Resource<ProductResponse>
}