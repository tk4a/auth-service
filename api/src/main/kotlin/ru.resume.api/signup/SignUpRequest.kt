package ru.resume.api.signup

data class SignUpRequest(
    val username: String,
    val password: String,
    val email: String
)
