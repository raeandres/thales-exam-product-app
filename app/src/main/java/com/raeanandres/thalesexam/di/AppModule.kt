package com.raeanandres.thalesexam.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

//    @Provides
//    fun provideDatabase(@ApplicationContext appContext: Context) : ProductsDb {
//        return ProductsDb.getDatabase(appContext)
//    }
//
//    @Provides
//    @Singleton
//    fun provideProductDao(db: ProductsDb): ProductDAO {
//        return db.productDao()
//    }
}