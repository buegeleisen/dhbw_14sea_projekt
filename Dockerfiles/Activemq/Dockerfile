FROM ubuntu:16.04

#JAVA
RUN apt-get update
RUN apt-get install -y openjdk-8-jre
RUN apt-get install dos2unix

#ENTRYPOINT
COPY entrypoint.sh /
RUN dos2unix /entrypoint.sh
RUN chmod u+x /entrypoint.sh

#ACTIVEMQ
ADD https://archive.apache.org/dist/activemq/5.11.3/apache-activemq-5.11.3-bin.tar.gz activemq.tgz
RUN tar -xzf /activemq.tgz && mv /apache-activemq-5.11.3 /activemq

#PORT
EXPOSE 61616

ENTRYPOINT /entrypoint.sh