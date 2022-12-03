package com.noweshed.noweshedmisltest.presentation.di

import com.noweshed.noweshedmisltest.data.api.ApiService
import com.noweshed.noweshedmisltest.data.repo.datasource.RemoteDataSource
import com.noweshed.noweshedmisltest.data.repo.implementdatasource.RemoteDataSourceImpl
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
class DataSourceModule {

    @Provides
    @Singleton
    fun providesRemoteDataSource(apiService: ApiService):RemoteDataSource{
        return RemoteDataSourceImpl(apiService = apiService)
    }
}