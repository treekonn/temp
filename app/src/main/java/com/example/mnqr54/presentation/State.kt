package com.example.mnqr54.presentation

sealed class State<T> {
    class Data<T>(val data: T) : State<T>()
    class Loading<Any> : State<Any>()
    class Error<Any>(val e: Throwable) : State<Any>()
}