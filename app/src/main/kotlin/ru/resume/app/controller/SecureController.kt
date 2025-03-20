package ru.resume.app.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SecureController {
    @PostMapping("/secure")
    fun test() = "OK"
}