package ru.resume.app.service

import ru.resume.api.signup.SignUpRequest
import ru.resume.api.signup.SignUpResponse

interface SignUpService {
    suspend fun signUp(request: SignUpRequest): SignUpResponse
}