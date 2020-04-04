FROM openjdk:13-alpine AS builder

ENV JAVA_HOME=/opt/openjdk-13 \
    PATH=${PATH}:/opt/openjdk-13/bin \
    LANG=C.UTF-8

COPY ./env-vars-app/target/env-vars-app-1.0-SNAPSHOT.jar .
COPY ./env-vars-util/target/env-vars-util-1.0-SNAPSHOT.jar .

RUN jlink --module-path env-vars-app-1.0-SNAPSHOT.jar:env-vars-util-1.0-SNAPSHOT.jar \
        --add-modules java.base,patternbox.javamodules.util,patternbox.javamodules.app \
        --output dist \
        --compress 2 \
        --strip-java-debug-attributes \
        --no-header-files \
        --no-man-pages

FROM alpine:latest
COPY --from=builder /dist /opt/jdk/
ENV PATH=$PATH:/opt/jdk/bin

CMD ["java", "--module", "patternbox.javamodules.app/com.patternbox.javamodules.app.EnvVarsApplication"]