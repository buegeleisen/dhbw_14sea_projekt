FROM ubuntu:16.04
MAINTAINER Ja.com

#JAVA
RUN apt-get update
RUN apt-get install -y openjdk-8-jre

#ENTRYPOINT
COPY entrypoint.sh /
RUN chmod u+x /entrypoint.sh

#TAKTSTRASSE
COPY TaktstrasseOpcServer-0.0.1-SNAPSHOT.jar /
RUN chmod u+x /TaktstrasseOpcServer-0.0.1-SNAPSHOT.jar

#UNSEREJAR
COPY UNSEREJAR.jar /
RUN chmod u+x /UNSEREJAR.jar

#ALLEORDNER
RUN mkdir -p /BLABLA

ENTRYPOINT /entrypoint.sh
