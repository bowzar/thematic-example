FROM java:8
VOLUME /tmp
ADD com.yulintu.thematic-example-employee-boot.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]