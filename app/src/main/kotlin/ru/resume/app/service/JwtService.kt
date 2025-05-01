package ru.resume.app.service

import ru.resume.api.token.TokenRequestDto

interface JwtService {
    suspend fun generateToken(email: String): String
    suspend fun validateToken(request: TokenRequestDto): Boolean
}