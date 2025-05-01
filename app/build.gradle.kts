plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version Version.KOTLIN_SPRING
    id("org.springframework.boot") version Version.SPRING
    id("io.spring.dependency-management") version Version.DEPENDENCY_MANAGEMENT
}

tasks {
    bootJar { archiveFileName.set("app.jar") }

    jar { enabled = false }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("io.micrometer:micrometer-registry-prometheus")

    implementation("io.r2dbc:r2dbc-postgresql:${Version.R2DBC_POSTGRESQL}")

    implementation("io.jsonwebtoken:jjwt-api:${Version.JSON_WEB_TOKEN}")
    implementation("io.jsonwebtoken:jjwt-impl:${Version.JSON_WEB_TOKEN}")
    implementation("io.jsonwebtoken:jjwt-gson:${Version.JSON_WEB_TOKEN}")

    api(project(":api"))
}