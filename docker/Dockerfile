FROM java:openjdk-8-jre-alpine

ADD src /opt/src/

WORKDIR /opt/src/

ENTRYPOINT ["java","-jar","MockMock.jar","-p","2525","-h","8080"]