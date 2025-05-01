package ru.resume.api.login

data class LoginRequest(
    val email: String,
    val password: String
) {
    constructor() : this("", "")
}
