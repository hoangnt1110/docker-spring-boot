FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/resume-0.0.1-SNAPSHOT.jar resume-app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /resume-app.jar" ]
