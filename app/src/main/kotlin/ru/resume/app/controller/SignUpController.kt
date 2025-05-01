package ru.resume.app.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.resume.api.signup.SignUpRequest
import ru.resume.api.signup.SignUpResponse
import ru.resume.app.service.SignUpService

@RestController
class SignUpController(private val signUpService: SignUpService) {
    @PostMapping("/sign-up")
    suspend fun signUp(@RequestBody request: SignUpRequest): SignUpResponse = signUpService.signUp(request)
}