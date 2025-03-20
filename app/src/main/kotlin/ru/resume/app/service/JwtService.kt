package ru.resume.app.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Encoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.KeyGenerator

@Service
class JwtService {
    fun generateToken(username: String): String =
        Jwts.builder()
            .subject(username)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + 3600000))  // 1 час
            .signWith(SECRET_KEY)
            .compact()

    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .payload
            true
        } catch (e: Exception) {
            false
        }
    }


    companion object { private val SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(Encoders.BASE64.encode(KeyGenerator.getInstance("HmacSHA256").apply { init(256) }.generateKey().encoded))) }
}