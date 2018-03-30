FROM java:8
VOLUME /tmp
ADD com.yulintu.thematic-example-employee-web.jar app.jar

ENV PARAMS=""

ENTRYPOINT ["sh","-c","java -Djava.security.egd=file:/dev/./urandom -jar /app.jar ${PARAMS}"]