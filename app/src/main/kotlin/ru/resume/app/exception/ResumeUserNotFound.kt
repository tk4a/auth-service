package ru.resume.app.exception

data class ResumeUserNotFound(private val exceptionMessage: String) : RuntimeException(exceptionMessage) {
}