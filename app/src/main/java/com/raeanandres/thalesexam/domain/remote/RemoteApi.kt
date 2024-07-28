package com.raeanandres.thalesexam.domain.remote


import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import com.raeanandres.thalesexam.model.Product


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
        return httpClient.get("http://10.0.2.2:3000/products").body()
    }
}
