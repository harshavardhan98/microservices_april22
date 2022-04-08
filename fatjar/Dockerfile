FROM openjdk:latest

RUN apk --no-cache add curl

LABEL MAINTAINER Dr.Rao

EXPOSE 9000

COPY firstexample-0.0.1-SNAPSHOT.jar .

CMD java -jar firstexample-0.0.1-SNAPSHOT.jar