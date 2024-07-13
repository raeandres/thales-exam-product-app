package com.raeanandres.thalesexam.domain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raeanandres.thalesexam.domain.dao.ProductDAO
import com.raeanandres.thalesexam.domain.entity.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductsDb : RoomDatabase() {

    abstract fun productDao(): ProductDAO

    companion object {
        @Volatile
        private var INSTANCE: ProductsDb? = null
        private const val DB_NAME = "products_database"

        fun getDatabase(context: Context): ProductsDb {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductsDb::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}