package ru.resume.app.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.resume.app.dto.LoginRequest
import ru.resume.app.dto.LoginResponse

@Service
class LoginServiceImpl(private val jwtService: JwtService) : LoginService {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)
    
    override fun doLogin(request: LoginRequest): ResponseEntity<LoginResponse> {
        log.info("Get request for login with body: $request")
        return ResponseEntity.ok(LoginResponse(jwtService.generateToken(request.email)))
    }
}