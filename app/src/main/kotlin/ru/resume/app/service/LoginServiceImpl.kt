package ru.resume.app.service

import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import ru.resume.app.dto.LoginRequest
import ru.resume.app.dto.LoginResponse

@Service
class LoginServiceImpl(private val jwtService: JwtService, private val authenticationManager: AuthenticationManager) : LoginService {
    override fun doLogin(request: LoginRequest): ResponseEntity<LoginResponse> {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.username, request.password))
        val token = jwtService.generateToken(request.username)
        return ResponseEntity.ok(LoginResponse(token))
    }
}