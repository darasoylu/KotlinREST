package com.darasoylu.kotlinrest.repository

import com.darasoylu.kotlinrest.di.RetrofitModule
import com.darasoylu.kotlinrest.model.User
import retrofit2.Response

class UserRepository {

    suspend fun getUsers(): Response<List<User>> = RetrofitModule.api.getUsers()

    suspend fun postUser(user: User) = RetrofitModule.api.postUser(user)

    suspend fun getUser(id: String): Response<User> = RetrofitModule.api.getUser(id)

    suspend fun updateUser(id: String, user: User) = RetrofitModule.api.updateUser(id, user)

    suspend fun deleteUser(id: String) = RetrofitModule.api.deleteUser(id)
}