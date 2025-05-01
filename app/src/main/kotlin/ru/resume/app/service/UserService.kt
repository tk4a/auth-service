package ru.resume.app.service

import reactor.core.publisher.Mono
import ru.resume.api.user.UserRequestDto
import ru.resume.api.user.UserResponseDto

interface UserService {
    suspend fun getUserByUserName(dto: UserRequestDto): Mono<UserResponseDto>
}