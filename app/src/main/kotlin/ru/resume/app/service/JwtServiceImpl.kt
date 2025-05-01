package ru.resume.app.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Encoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service
import ru.resume.api.token.TokenRequestDto
import java.util.*
import javax.crypto.KeyGenerator

@Service
class JwtServiceImpl : JwtService {
    override suspend fun generateToken(email: String): String =
        Jwts.builder()
            .setSubject(email)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 3600000))  // 1 час
            .signWith(SECRET_KEY)
            .compact()

    override suspend fun validateToken(request: TokenRequestDto): Boolean {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(request.token)
                .body
            true
        } catch (e: Exception) {
            false
        }
    }


    companion object { private val SECRET_KEY = Keys.hmacShaKeyFor(Base64.getDecoder().decode(Encoders.BASE64.encode(KeyGenerator.getInstance("HmacSHA256").apply { init(256) }.generateKey().encoded))) }
}