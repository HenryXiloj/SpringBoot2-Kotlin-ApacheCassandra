package com.henry.services

import com.henry.model.Users

interface UserService {
    fun byContName(name: String): List<Users?>?
    fun findAllUsers(): MutableList<Users>;
    fun saveUser(user: Users): Users
    fun updateUser(email: String, user: Users): Users
    fun deleteUser(email: String)
}