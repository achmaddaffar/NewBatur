package com.daffa.batur.util

sealed class Resources<T> (
    val data: T? = null,
    val message: String? = null
){

    class Success<T>(data: T) : Resources<T>(data)

    class Loading<T>(data: T? = null) : Resources<T>(data)

    class Error<T>(message: String? = null, data: T? = null) : Resources<T>(data, message)

    class Nothing<T>(): Resources<T>()
}