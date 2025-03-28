package ru.resume.app.service

import ru.resume.app.dto.SignUpRequest

interface SignUpService {
    fun signUp(request: SignUpRequest)
}