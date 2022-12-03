package com.noweshed.noweshedmisltest.presentation.di

import android.app.Application
import com.noweshed.noweshedmisltest.domain.usecase.ProductUseCase
import com.noweshed.noweshedmisltest.presentation.viewmodel.ProductViewModel
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
class ViewModelModule {

    @Singleton
    @Provides
    fun providesProductViewModel(
        app: Application,
        productUseCase: ProductUseCase
    ): ProductViewModel {
        return ProductViewModel(app, productUseCase)
    }

}