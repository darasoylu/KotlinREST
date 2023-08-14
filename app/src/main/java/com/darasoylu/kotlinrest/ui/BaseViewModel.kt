package com.darasoylu.kotlinrest.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darasoylu.kotlinrest.model.User
import com.darasoylu.kotlinrest.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class BaseViewModel() : ViewModel() {

    private val repository = UserRepository()
    val users: MutableLiveData<Response<List<User>>> = MutableLiveData()
    val user: MutableLiveData<Response<User>> = MutableLiveData()

    fun getUsers() {
        viewModelScope.launch {
            val response = repository.getUsers()
            users.value = response
        }
    }

    fun postUser(user: User) {
        viewModelScope.launch {
            repository.postUser(user)
        }
    }

    fun getUser(id: String) {
        viewModelScope.launch {
            val response = repository.getUser(id)
            user.value = response
        }
    }

    fun updateUser(id: String, updateUser: User) {
        viewModelScope.launch {
            repository.updateUser(id, updateUser)
        }
    }

    fun deleteUser(id: String) {
        viewModelScope.launch {
            repository.deleteUser(id)
        }
    }

}