plugins {
    kotlin("jvm") version Version.KOTLIN
}

group = GROUP_NAME
version = VERSION

apply("$rootDir/repositories.gradle.kts")

subprojects {
    val module = getModuleByName(name)

    group = module.group
    version = module.version

    apply("$rootDir/repositories.gradle.kts")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}