FROM 172.21.0.99/base/openjdk:8u232-bash

ENV DIST_NAME=cp-auth-manage-service

COPY target/"$DIST_NAME.jar" app.jar

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ENTRYPOINT ["java", "-jar", "app.jar", "-c"]
