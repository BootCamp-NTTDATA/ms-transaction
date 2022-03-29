FROM openjdk:11
VOLUME /tmp.
EXPOSE  8084
ADD     ./target/ms-transaction-0.0.1-SNAPSHOT.jar "ms-transaction.jar"
ENTRYPOINT ["java","-jar","ms-transaction.jar"]