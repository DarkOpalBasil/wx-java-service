# 基础镜像
FROM openjdk:17
# 指定工作目录
WORKDIR /app
# 将jar包添加到工作目录 /app
ADD target/wx-admin-1.0-SNAPSHOT.jar .
# 暴露端口
EXPOSE 8085
# 入口
ENTRYPOINT ["java", "-jar", "/app/wx-admin-1.0-SNAPSHOT.jar", "--spring.profiles.active=prod"]