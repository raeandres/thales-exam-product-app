package com.raeanandres.thalesexam.di

import android.content.Context
import androidx.room.Room
import com.raeanandres.thalesexam.domain.ProductsDb
import com.raeanandres.thalesexam.domain.dao.ProductDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

private const val DB_NAME = "products_database"

@Module
@Singleton
class AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) : ProductsDb {
        return ProductsDb.getDatabase(appContext)
    }

    @Provides
    @Singleton
    fun provideProductDao(db: ProductsDb): ProductDAO {
        return db.productDao()
    }
}