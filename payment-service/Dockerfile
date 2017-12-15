FROM fabric8/java-alpine-openjdk8-jre

VOLUME /tmp

ARG JAR_FILE

ADD src/main/docker/wait-for.sh /deployments
RUN chmod +x /deployments/wait-for.sh

ADD target/${JAR_FILE} /deployments

ENV JAVA_APP_JAR ${JAR_FILE}
ENV JAVA_OPTIONS -Djava.security.egd=file:/dev/./urandom
ENV AB_OFF true

EXPOSE 8080

CMD [ "/deployments/wait-for.sh", "mongodb:27017", "-t", "300", "--", "/deployments/run-java.sh", "--spring.profiles.active=docker" ]
