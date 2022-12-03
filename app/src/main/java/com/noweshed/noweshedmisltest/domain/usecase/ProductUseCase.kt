package com.noweshed.noweshedmisltest.domain.usecase

import com.noweshed.noweshedmisltest.data.model.response.ProductItem
import com.noweshed.noweshedmisltest.data.model.response.ProductResponse
import com.noweshed.noweshedmisltest.data.util.Resource
import com.noweshed.noweshedmisltest.domain.repo.ProductRepo
import javax.inject.Inject

/**
 * Created by noweshedakram on 3/12/22.
 */
class ProductUseCase @Inject constructor(
    private val productRepo: ProductRepo
) {
    suspend fun getAllProducts(secretCode: String): Resource<ProductItem> {
        return productRepo.getAllProducts(secretCode = secretCode)
    }

    suspend fun getProductById(secretCode: String, itemId: Int): Resource<ProductResponse> {
        return productRepo.getProductById(secretCode = secretCode, itemId = itemId)
    }
}