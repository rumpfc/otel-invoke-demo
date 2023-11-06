FROM maven:3.9.5-eclipse-temurin-17-alpine AS mvn_build

COPY ./ ./

RUN mvn clean package

FROM eclipse-temurin:17.0.9_9-jre-alpine

RUN mkdir /home/rumpfc
COPY --from=mvn_build /target/otel-invoke-demo-*.jar /home/rumpfc/app.jar

WORKDIR /home/rumpfc
RUN wget https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar

ENTRYPOINT ["java", "-javaagent:opentelemetry-javaagent.jar", "-jar", "app.jar"]