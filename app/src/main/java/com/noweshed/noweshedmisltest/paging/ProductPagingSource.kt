package com.noweshed.noweshedmisltest.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.noweshed.noweshedmisltest.data.model.response.ProductItem
import com.noweshed.noweshedmisltest.data.repo.implementdatasource.RemoteDataSourceImpl

/**
 * Created by Md. Noweshed Akram on 12/5/2022.
 */
class ProductPagingSource(private val remoteDataSourceImpl: RemoteDataSourceImpl) :
    PagingSource<Int, ProductItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductItem> {
        TODO("Not yet implemented")
    }

    override fun getRefreshKey(state: PagingState<Int, ProductItem>): Int? {
        TODO("Not yet implemented")
    }

}