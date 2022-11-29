FROM openjdk:8-jre

ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

VOLUME /tmp

ADD target/synchro-dns.jar synchro-dns.jar

ENTRYPOINT ["java","-jar","/synchro-dns.jar"]

EXPOSE 8080
