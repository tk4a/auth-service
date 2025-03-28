package ru.resume.app.dto

data class LoginRequest(
    val email: String,
    val password: String
) {
    constructor() : this("", "")
}
