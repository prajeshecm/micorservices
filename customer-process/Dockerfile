FROM openjdk:15
# generally this will companies contaner registry in real-time , not just any open operating system.

ARG JAR_FILE=process-0.0.1-SNAPSHOT.jar
# we can reuse the jar file variable where-ever we wants using the args variables .
COPY ./target/${JAR_FILE} app.jar
EXPOSE 8085
#ENV JAVA_OPTS=
ENTRYPOINT ["java","-jar","app.jar"]



#https://docs.docker.com/engine/reference/commandline/build/
#build :
