package ru.resume.app.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.resume.api.login.LoginRequest
import ru.resume.api.login.LoginResponse

@Service
class LoginServiceImpl(private val jwtService: JwtServiceImpl) : LoginService {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    
    override fun doLogin(request: LoginRequest): LoginResponse {
        logger.info("Get request for login with body: $request")
        return LoginResponse(jwtService.generateToken(request.email))
    }
}