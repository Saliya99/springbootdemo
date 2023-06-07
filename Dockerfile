FROM openjdk:17
EXPOSE 8080
WORKDIR project
ADD ./target/springbootdemo-0.0.1-SNAPSHOT.jar /project
ENTRYPOINT ["java", "-jar", "springbootdemo-0.0.1-SNAPSHOT.jar", "--type='local'"]