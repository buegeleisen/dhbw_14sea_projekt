FROM ubuntu:16.04

#JAVA
RUN apt-get update
RUN apt-get install -y openjdk-8-jre
RUN apt-get install dos2unix

#ENTRYPOINT
COPY entrypoint.sh /
RUN dos2unix /entrypoint.sh
RUN chmod u+x /entrypoint.sh

#UNSEREJAR
COPY Consumer.jar /
RUN chmod u+x /Consumer.jar

#SIMULATION
COPY TaktstrasseOpcServer-0.0.1-SNAPSHOT.jar /
RUN chmod u+x /TaktstrasseOpcServer-0.0.1-SNAPSHOT.jar

#TEMPORÄRE PFADE
RUN mkdir -p /ERP
RUN mkdir -p /ERPp

ENTRYPOINT /entrypoint.sh