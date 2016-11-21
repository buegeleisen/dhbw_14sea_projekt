FROM ubuntu:16.04

#JAVA
RUN apt-get update
RUN apt-get install -y openjdk-8-jre
RUN apt-get install dos2unix

#ENTRYPOINT
COPY entrypoint.sh /
RUN dos2unix /entrypoint.sh
RUN chmod u+x /entrypoint.sh

#KAFKA
ADD http://mirror.23media.de/apache/kafka/0.10.1.0/kafka_2.11-0.10.1.0.tgz /kafka.tgz
RUN tar -xzf /kafka.tgz && mv /kafka_2.11-0.10.1.0 /kafka

#KAFKA
EXPOSE 9092
EXPOSE 2181

ENTRYPOINT /entrypoint.sh