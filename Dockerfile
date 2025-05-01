# Используем официальный образ OpenJDK (slim — не содержит лишнего, но достаточно инструментов)
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR-файл в образ
COPY app/build/libs/app.jar app.jar

# Уменьшаем время запуска JVM в контейнере
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XX:InitialRAMPercentage=50.0 -XshowSettings:vm"

# Устанавливаем утилиты
RUN apt-get update && apt-get install -y procps net-tools

# Открываем порт, который слушает приложение
EXPOSE 8080

# Используем shell-форму, чтобы переменные окружения работали
CMD java $JAVA_OPTS -jar app.jar