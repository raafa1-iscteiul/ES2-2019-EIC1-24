FROM maven:3.6.3-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml -DskipTests clean package
#
# Package stage
#
FROM openjdk:8u92-jre-alpine
COPY --from=build /home/app/target/ES2-2019-EIC1-24-0.0.1-SNAPSHOT.jar /usr/local/lib/ES2-2019-EIC1-24-0.0.1-SNAPSHOT.jar
CMD ["java -jar ES2-2019-EIC1-24-0.0.1-SNAPSHOT.jar"]
