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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.micrometer:micrometer-registry-prometheus")
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    implementation("io.jsonwebtoken:jjwt-impl:0.12.6")
    implementation("io.jsonwebtoken:jjwt-gson:0.12.6")
}