FROM openjdk:17
LABEL maintainer ="RKS07"

ADD target/TMS-0.0.1-SNAPSHOT.jar dockerSpringBootDemo.jar

ENTRYPOINT ["java","-jar","dockerSpringBootDemo.jar"]