package ru.resume.app.service

import org.springframework.http.ResponseEntity
import ru.resume.app.dto.LoginRequest
import ru.resume.app.dto.LoginResponse

interface LoginService {
    fun doLogin(request: LoginRequest): ResponseEntity<LoginResponse>
}