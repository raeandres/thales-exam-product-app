package com.raeanandres.thalesexam.domain.remote

sealed class Response<T> (val data: T ?= null, val message: String ?= null) {
    class Success<T>(data: T?):Response<T>(data)
    class Error<T>(message: String?, data: T?): Response<T>(data,message)
}