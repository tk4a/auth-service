const val GROUP_NAME = "ru.resume"
const val VERSION = "1.0-SNAPSHOT"

object Version {
    const val KOTLIN = "1.8.0"
    const val KOTLIN_SPRING = "1.8.0"
    const val SPRING = "3.2.0"
    const val DEPENDENCY_MANAGEMENT = "1.1.4"
    const val JSON_WEB_TOKEN = "0.11.5"
    const val R2DBC_POSTGRESQL = "0.8.10.RELEASE"
}

val modules = listOf(Module("$GROUP_NAME.app", "app", VERSION), Module("$GROUP_NAME.api", "api", VERSION))

fun getModuleByName(name: String) = modules.first { it.name == name }

data class Module(val group: String, val name: String, val version: String)