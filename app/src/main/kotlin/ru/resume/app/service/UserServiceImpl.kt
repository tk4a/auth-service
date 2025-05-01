package ru.resume.app.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import ru.resume.api.user.UserRequestDto
import ru.resume.api.user.UserResponseDto
import ru.resume.app.mapper.toUserResponseDto
import ru.resume.app.repository.RocketUserRepository

@Service
class UserServiceImpl(private val repository: RocketUserRepository) : UserService {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override suspend fun getUserByUserName(dto: UserRequestDto): Mono<UserResponseDto> {
        logger.info("Get request for find user by email: ${dto.email}")
        return repository.findByEmail(dto.email).map { it?.toUserResponseDto() ?: UserResponseDto("", "") }
    }
}