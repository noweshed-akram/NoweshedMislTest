package com.noweshed.noweshedmisltest.data.repo

import com.noweshed.noweshedmisltest.data.model.response.ProductItem
import com.noweshed.noweshedmisltest.data.model.response.ProductResponse
import com.noweshed.noweshedmisltest.data.repo.datasource.RemoteDataSource
import com.noweshed.noweshedmisltest.data.util.Resource
import com.noweshed.noweshedmisltest.domain.repo.ProductRepo
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by noweshedakram on 3/12/22.
 */
class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ProductRepo {

    private fun responseToProductDetails(response: Response<ProductResponse>): Resource<ProductResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }

    private fun responseToProductList(response: Response<ProductItem>): Resource<ProductItem> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }

    override suspend fun getAllProducts(secretCode: String): Resource<ProductItem> {
        return responseToProductList(remoteDataSource.getAllProducts(secretCode = secretCode))
    }

    override suspend fun getProductById(
        secretCode: String,
        itemId: Int
    ): Resource<ProductResponse> {
        return responseToProductDetails(
            remoteDataSource.getProductById(
                secretCode = secretCode,
                itemId = itemId
            )
        )
    }
}