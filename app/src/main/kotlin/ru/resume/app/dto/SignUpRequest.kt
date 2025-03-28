package ru.resume.app.dto

data class SignUpRequest(
    val username: String,
    val password: String,
    val email: String
) {
    constructor() : this("", "", "")
}
