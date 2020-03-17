FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE
COPY target/*.jar . url-shortening.jar
#COPY --from=build /tmp/target/url-shortener.jar url-shortener.jar
#ADD /target/url-shortening.jar url-shortening.jar
#RUN bash -c 'touch target/url-shortening.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/url-shortening.jar"]