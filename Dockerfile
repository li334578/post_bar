# 第一阶段：构建阶段 —— 使用 Maven 打包项目
FROM maven:3.8.6-openjdk-8-slim AS builder

WORKDIR /build

# 先复制 pom.xml，提前下载依赖（利用缓存优化）
COPY pom.xml .

# 下载所有依赖
RUN mvn dependency:go-offline

# 复制源码
COPY src ./src

# 打包项目（跳过测试，如不需要可去掉 -DskipTests）
RUN mvn package -DskipTests

# 提取生成的 jar 文件
RUN mkdir -p /jar && cp target/*.jar /jar/app.jar


# 第二阶段：运行阶段 —— 只包含运行所需的最小环境
FROM openjdk:8-jre-slim

WORKDIR /app

# 创建非 root 用户
RUN adduser --disabled-password --gecos '' appuser && \
    chown -R appuser:appuser /app
USER appuser

# 从构建阶段复制 jar 文件
COPY --from=builder /jar/app.jar ./app.jar

EXPOSE 80

ENTRYPOINT ["java", "-jar", "./app.jar"]