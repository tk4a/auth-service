package ru.resume.app.repository

import ru.resume.app.entity.ResumeUser

interface UserRepository {
    fun save(user: ResumeUser)
    fun getUserByUsername(username: String): ResumeUser
}