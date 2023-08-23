# 第一阶段：编译代码
FROM maven:3.8.4-openjdk-11 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ src/
RUN mvn package -DskipTests


# 第二阶段：构建镜像
FROM openjdk:11-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/my-application.jar my-application.jar

EXPOSE 8080

CMD ["java", "-jar", "my-application.jar"]
