package com.example.eightbelajarsemuanyakecualifragment.utils

sealed class Resource<T>(val data: T? = null, val msg: String) {
    class Ok<T>(data: T, message: String) : Resource<T>(data = data, msg = message)
    class Failed<T>(message: String) : Resource<T>(msg = message)
}