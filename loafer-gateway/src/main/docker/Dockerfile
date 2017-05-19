# 基于哪个镜像
FROM java:8-jre-alpine

# 将本地文件夹挂载到当前容器
VOLUME /tmp

# 拷贝文件到容器
ADD *.jar app.jar
RUN sh -c 'touch /app.jar'

# 开放8050端口
EXPOSE 8050

# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
