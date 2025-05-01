package ru.resume.app.mapper

import ru.resume.api.user.UserResponseDto
import ru.resume.api.signup.SignUpRequest
import ru.resume.app.entity.RocketUser

fun SignUpRequest.toUser() =
        RocketUser(
            null,
            this.email,
            this.password,
            "",
            "",
            ""
        )

fun RocketUser.toUserResponseDto() =
    UserResponseDto(
        this.email,
        this.password
    )