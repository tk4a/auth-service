package ru.resume.app.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import ru.resume.api.user.UserRequestDto
import ru.resume.api.user.UserResponseDto
import ru.resume.app.service.UserService

@RestController
class UserController(private val userService: UserService) {
    /**
     * Get user by email
     */
    @PostMapping("/user")
    suspend fun getUserByEmail(@RequestBody request: UserRequestDto): Mono<UserResponseDto> = userService.getUserByUserName(request)
}