package ru.resume.app.service

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.resume.app.repository.UserRepository

@Service
class ResumeUserDetailService(
    private val passwordEncoder: PasswordEncoder,
    private val repository: UserRepository
    ) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repository.getUserByUsername(username ?: "")
        return User.builder()
            .username(user.email)
            .password(passwordEncoder.encode(user.password))
            .authorities(SimpleGrantedAuthority("USER"))
            .build()
    }
}