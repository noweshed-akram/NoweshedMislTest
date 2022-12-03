package com.noweshed.noweshedmisltest.presentation.di

import com.noweshed.noweshedmisltest.data.repo.RepositoryImpl
import com.noweshed.noweshedmisltest.data.repo.datasource.RemoteDataSource
import com.noweshed.noweshedmisltest.domain.repo.ProductRepo
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
class RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(
        remoteDataSource: RemoteDataSource
    ): ProductRepo {
        return RepositoryImpl(
            remoteDataSource = remoteDataSource
        )
    }

}