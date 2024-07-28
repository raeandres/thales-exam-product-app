package com.raeanandres.thalesexam.domain.remote


import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import com.raeanandres.thalesexam.model.Product
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType


class RemoteApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getAllProducts(): List<Product> {
       return try {
           httpClient.get(Constants.PRODUCTS_ENDPOINT).body()
       } catch (ex: Exception) {
           listOf()
       }
    }


    suspend fun addProduct(product: Product) : Boolean  {
        return try {
            httpClient.post {
                url(Constants.PRODUCT_ENDPOINT)
                contentType(ContentType.Application.Json)
                setBody(product)
            }
            true
        } catch (e: Exception) {
            Product.init
            false
        }
    }
}
