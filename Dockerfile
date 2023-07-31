FROM khipu/openjdk17-alpine
EXPOSE 9999
ADD target/configuration_spring_boot_app-0.0.1-SNAPSHOT.jar /opt/app/app.jar
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]