FROM openjdk:8

RUN mkdir -p /opt/app

WORKDIR /opt/app

COPY ./execute.sh ./target/scala-2.12/mutantTest-API.jar ./

ENTRYPOINT ["./execute.sh"]

EXPOSE 8080