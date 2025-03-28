package ru.resume.app.config

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.filter.OncePerRequestFilter
import ru.resume.app.dto.LoginRequest

class JwtAuthenticationFilter(
    private val objectMapper: ObjectMapper,
    private val userDetailsService: UserDetailsService,
    private val passwordEncoder: PasswordEncoder,
    private val authenticationManager: AuthenticationManager
) : OncePerRequestFilter() {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun shouldNotFilter(request: HttpServletRequest): Boolean = "/sign-up" == request.requestURI

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val contentCachingRequestWrapper = CachedBodyHttpServletRequest(request)
        val body = objectMapper.readValue(contentCachingRequestWrapper.inputStream, LoginRequest::class.java)
        val user = userDetailsService.loadUserByUsername(body.email)
        log.info("Get request with username: ${user.username}")
        if (passwordEncoder.matches(body.password, user.password)) {
            val auth = UsernamePasswordAuthenticationToken(
                body.email,
                body.password,
                listOf(SimpleGrantedAuthority("USER"))
            )
            val authentication = authenticationManager.authenticate(auth)
            SecurityContextHolder.getContext().authentication = authentication
        } else response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed")
        chain.doFilter(contentCachingRequestWrapper, response)
    }
}