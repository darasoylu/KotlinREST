package com.darasoylu.kotlinrest.di

import com.darasoylu.kotlinrest.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @POST("users")
    suspend fun postUser(
        @Body user: User
    )

    @GET("users/{id}")
    suspend fun getUser(
        @Path("id") userId: String
    ): Response<User>

    @PATCH("users/{id}")
    suspend fun updateUser(
        @Path("id") userId: String,
        @Body user: User
    )

    @DELETE("users/{id}")
    suspend fun deleteUser(
        @Path("id") userId: String
    )

}