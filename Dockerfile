# Используем официальный образ OpenJDK с Alpine Linux (минимальный размер)
FROM eclipse-temurin:17-jre-alpine

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл в образ
COPY app/build/libs/app.jar app.jar

# Уменьшаем время запуска JVM в контейнере
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XX:InitialRAMPercentage=50.0 -XshowSettings:vm"

# Открываем порт, который слушает приложение
EXPOSE 8080

# Запуск приложения (используем shell-form для переменных окружения)
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar