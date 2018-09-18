FROM openjdk:8-jdk-alpine
ADD target/call-0.0.1-SNAPSHOT.jar call-0.0.1.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /call-0.0.1.jar