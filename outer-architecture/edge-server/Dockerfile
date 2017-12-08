FROM fabric8/java-alpine-openjdk8-jdk

VOLUME /tmp

ARG JAR_FILE

ADD target/${JAR_FILE} /deployments

ENV JAVA_APP_JAR ${JAR_FILE}
ENV JAVA_OPTIONS -Djava.security.egd=file:/dev/./urandom
ENV AB_OFF true

EXPOSE 8080

CMD [ "/deployments/run-java.sh", "--spring.profiles.active=docker" ]
