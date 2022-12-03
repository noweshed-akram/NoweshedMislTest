package com.noweshed.noweshedmisltest.presentation.di

import com.noweshed.noweshedmisltest.presentation.adapter.ProductAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by noweshedakram on 3/12/22.
 */

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun providesHomeAdapter() : ProductAdapter {
        return ProductAdapter()
    }
}