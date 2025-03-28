package ru.resume.app.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.resume.app.dto.SignUpRequest
import ru.resume.app.service.SignUpService

@RestController
class SignUpController(private val signUpService: SignUpService) {
    @PostMapping("/sign-up")
    fun signUp(@RequestBody request: SignUpRequest) {
        signUpService.signUp(request)
    }
}