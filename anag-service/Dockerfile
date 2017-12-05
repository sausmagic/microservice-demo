FROM fabric8/java-alpine-openjdk8-jdk
VOLUME /tmp

ARG JAR_FILE
ARG APP_FILENAME

ADD ${JAR_FILE} /app/

ENV JAVA_APP_JAR ${APP_FILENAME}
ENV JAVA_OPTIONS -Djava.security.egd=file:/dev/./urandom
ENV AB_OFF true

EXPOSE 8080
