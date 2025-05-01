package ru.resume.app.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.resume.api.token.TokenRequestDto
import ru.resume.app.service.JwtService

@RestController
class JwtController(private val jwtService: JwtService) {
    @GetMapping("/jwt/{email}")
    suspend fun generateToken(@PathVariable email: String) = jwtService.generateToken(email)

    @PostMapping("/jwt")
    suspend fun validateToken(@RequestBody token: TokenRequestDto) = jwtService.validateToken(token)
}