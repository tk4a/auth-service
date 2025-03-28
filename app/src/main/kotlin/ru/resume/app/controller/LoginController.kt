package ru.resume.app.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.resume.app.dto.LoginRequest
import ru.resume.app.dto.LoginResponse
import ru.resume.app.service.LoginService

@RestController
class LoginController(private val loginService: LoginService) {
    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> = loginService.doLogin(request)
}