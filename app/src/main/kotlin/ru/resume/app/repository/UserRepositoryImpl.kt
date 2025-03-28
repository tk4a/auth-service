package ru.resume.app.repository

import org.springframework.stereotype.Service
import ru.resume.app.entity.ResumeUser
import ru.resume.app.exception.ResumeUserNotFound

@Service
class UserRepositoryImpl : UserRepository {
    override fun save(user: ResumeUser) {
        REPOSITORY[user.id] = user
    }

    override fun getUserByUsername(username: String) = REPOSITORY.values.firstOrNull { it.email == username } ?: throw ResumeUserNotFound("User with username: $username not found")

    companion object { private val REPOSITORY = mutableMapOf<String, ResumeUser>() }
}