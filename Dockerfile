FROM openjdk:18

COPY ./build/libs/academia-api-0.0.1-SNAPSHOT.jar app.jar

CMD ["java","-jar","app.jar"]