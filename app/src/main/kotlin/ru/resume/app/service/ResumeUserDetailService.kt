package ru.resume.app.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class ResumeUserDetailService : UserDetailsService{
    override fun loadUserByUsername(username: String?): UserDetails {
        return User.builder()
            .username("admin")
            .password("pass") // Пароль уже должен быть зашифрован
            .authorities("USER") // Или роли пользователя, если это необходимо
            .build()
    }
}