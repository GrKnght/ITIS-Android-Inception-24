package ru.itis.itis_android_inception_24.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.itis.itis_android_inception_24.data.dao.UserDao
import ru.itis.itis_android_inception_24.data.entities.UserEntity

class UserRepository(private val userDao: UserDao) {

    suspend fun getUserById(id: String): UserEntity {
        return withContext(Dispatchers.IO) {
            userDao.getUserById(id = id)
                ?: throw IllegalStateException("User with given id not found")
        }
    }

    suspend fun saveUser(user: UserEntity) {
        return withContext(Dispatchers.IO) {
            userDao.saveUserData(user = user)
        }
    }
}