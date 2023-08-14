package com.darasoylu.kotlinrest.model

data class User(
    val id: String?,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val image: String
)