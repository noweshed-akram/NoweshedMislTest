package com.noweshed.noweshedmisltest.data.api

import com.noweshed.noweshedmisltest.data.model.request.ProductReqById
import com.noweshed.noweshedmisltest.data.model.response.ProductItem
import com.noweshed.noweshedmisltest.data.model.response.ProductResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Created by noweshedakram on 3/12/22.
 */
interface ApiService {

    @GET("products")
    suspend fun getAllProducts(@Header("Secret_Code") secretCode: String): Response<ProductItem>

    @POST("products/by_id")
    suspend fun getProductsById(
        @Header("Secret_Code") secretCode: String,
        @Body productReqById: ProductReqById
    ): Response<ProductResponse>

}