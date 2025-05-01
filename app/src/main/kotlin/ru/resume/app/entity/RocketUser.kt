package ru.resume.app.entity

import io.r2dbc.spi.Row
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "rocket_user")
data class RocketUser(
    @Id
    var userId: String? = null,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val position: String
) {
    companion object {
        fun fromRow(row: Row): RocketUser {
            return RocketUser(
                userId = row.get("user_id", String::class.java) ?: null,
                email = row.get("email", String::class.java) ?: "",
                password = row.get("password", String::class.java) ?: "",
                firstName = row.get("first_name", String::class.java) ?: "",
                lastName = row.get("last_name", String::class.java) ?: "",
                position = row.get("position", String::class.java) ?: ""
            )
        }
    }
}