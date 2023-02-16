FROM maven:3.6.3 as maven
LABEL COMPANY="ITSPA"
LABEL MAINTAINER="aayala@itspa.edu.mx"
LABEL APPLICATION="esgiitspa"

# COPY settings.xml /usr/share/maven/ref/
RUN pwd
RUN ls
COPY ./pom.xml /tmp/
COPY ./src /tmp/src/
# COPY settings.xml /usr/share/maven/ref/
# - mvn -f services/pom.xml clean compile $MAVEN_CLI_OPTS $MAVEN_OPTS package -DskipTests=true
# RUN mvn -B -f /tmp/pom.xml -Dmaven.repo.local=/root/.m2 -Dmaven.wagon.http.ssl.insecure=true -Dmaven.test.skip=true clean install
RUN --mount=type=cache,target=/root/.m2 mvn -f /tmp/pom.xml clean package

FROM tomcat:8.5-jdk15-openjdk-oracle

ENV CATALINA_OPTS="-Xms1024m -Xmx4096m -XX:MetaspaceSize=512m -XX:MaxMetaspaceSize=512m -Xss512k"

#Move over the War file from previous build step
WORKDIR /usr/local/tomcat/webapps/
COPY --from=maven /tmp/target/scse-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/esgiitspa.war

EXPOSE 8081
CMD ["/bin/bash"]
ENTRYPOINT ["catalina.sh", "run"]
