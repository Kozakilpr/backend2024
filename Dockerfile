FROM maven:3.8.3-openjdk-17 as build

WORKDIR /workspace/app

COPY pom.xml .
COPY src src

RUN mvn -DskipTests=true clean package

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:17.0.1-jdk-slim

ARG DEPENDENCY=/workspace/application/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /application/lib
COPY --from=build ${DEPENDENCY}/META-INF /application/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /application

ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.kozak_burger.KozakBurgerShop.KozakBurgerShopApplication"]
