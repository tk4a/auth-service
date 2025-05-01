package ru.resume.app.service

import ru.resume.api.login.LoginRequest
import ru.resume.api.login.LoginResponse

interface LoginService {
    fun doLogin(request: LoginRequest): LoginResponse
}