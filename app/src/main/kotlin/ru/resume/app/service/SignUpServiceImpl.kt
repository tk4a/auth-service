package ru.resume.app.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.resume.app.dto.SignUpRequest
import ru.resume.app.mapper.toUser
import ru.resume.app.repository.UserRepository

@Service
class SignUpServiceImpl(private val userRepository: UserRepository) : SignUpService {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun signUp(request: SignUpRequest) {
        log.info("Get request to sign up with body: $request")
        request.toUser().let { userRepository.save(it) }
    }
}