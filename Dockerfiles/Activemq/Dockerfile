FROM ubuntu:16.04
MAINTAINER Ja.com

#JAVA
RUN apt-get update
RUN apt-get install -y openjdk-8-jre

#ENTRYPOINT 
COPY entrypoint.sh /
RUN chmod u+x /entrypoint.sh

#ACTIVEMQ
ADD https://archive.apache.org/dist/activemq/5.11.3/apache-activemq-5.11.3-bin.tar.gz activemq.tgz
RUN tar -xzf /activemq.tgz && mv /apache-activemq-5.11.3 /activemq

#PORTS
EXPOSE 8161
EXPOSE 61616
EXPOSE 5672
EXPOSE 61613
EXPOSE 1883
EXPOSE 61614

ENTRYPOINT /entrypoint.sh