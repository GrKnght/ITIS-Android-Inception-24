package ru.itis.itis_android_inception_24.data.db.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.itis.itis_android_inception_24.data.db.dao.FilmDao
import ru.itis.itis_android_inception_24.data.db.dao.UserAndPetDao
import ru.itis.itis_android_inception_24.data.db.dao.UserDao
import ru.itis.itis_android_inception_24.data.db.entities.FilmEntity
import ru.itis.itis_android_inception_24.data.db.entities.PetEntity
import ru.itis.itis_android_inception_24.data.db.entities.UserEntity
import ru.itis.itis_android_inception_24.data.db.model.UserAndPetsModel

class UserRepository(
    private val userDao: UserDao,
    private val filmDao: FilmDao,
    private val userAndPetDao: UserAndPetDao,
    private val ioDispatcher: CoroutineDispatcher,
) {
    suspend fun getUserById(id: String): UserEntity {
        return withContext(ioDispatcher) {
            userDao.getUserById(id = id)
                ?: throw IllegalStateException("User with given id not found")
        }
    }

    suspend fun saveUser(user: UserEntity) {
        return withContext(ioDispatcher) {
            userDao.saveUserData(user = user)
        }
    }

    suspend fun saveFilms(films: List<FilmEntity>) {
        return withContext(ioDispatcher) {
            films.forEach {
                filmDao.saveFilmInDb(it)
            }
        }
    }

    suspend fun saveFilm(film: FilmEntity) {
        return withContext(ioDispatcher) {
            filmDao.saveFilmInDb(filmData = film)
        }
    }

    suspend fun savePet(petEntity: PetEntity) {
        return withContext(ioDispatcher) {
            userAndPetDao.savePet(petEntity)
        }
    }

    suspend fun getUsersAndPets(): List<UserAndPetsModel>? {
        return withContext(ioDispatcher) {
            userAndPetDao.getUsersAndPets()
        }
    }
}