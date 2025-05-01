package ru.resume.app.repository

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import ru.resume.app.entity.RocketUser

@Repository
interface RocketUserRepository : ReactiveCrudRepository<RocketUser, String> {
    fun findByEmail(email: String): Mono<RocketUser?>
}