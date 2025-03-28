package ru.resume.app.mapper

import ru.resume.app.dto.SignUpRequest
import ru.resume.app.entity.ResumeUser
import java.util.UUID

fun SignUpRequest.toUser() =
        ResumeUser(
            UUID.randomUUID().toString(),
            this.username,
            this.password,
            this.email
        )