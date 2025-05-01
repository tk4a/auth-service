package ru.resume.app.service

import kotlinx.coroutines.reactive.awaitFirst
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.resume.api.signup.SignUpRequest
import ru.resume.api.signup.SignUpResponse
import ru.resume.app.mapper.toUser
import ru.resume.app.repository.RocketUserRepository

@Service
class SignUpServiceImpl(
    private val repository: RocketUserRepository,
    private val jwtService: JwtService
    ) : SignUpService {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override suspend fun signUp(request: SignUpRequest): SignUpResponse {
        log.info("Get request to sign up with body: $request")
        repository.save(request.toUser()).awaitFirst()
        return SignUpResponse(jwtService.generateToken(request.email))
    }
}