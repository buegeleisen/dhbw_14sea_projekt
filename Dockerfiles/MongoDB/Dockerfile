FROM ubuntu:16.04

#MONGOKEYUNDLISTE
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv EA312927
RUN echo "deb http://repo.mongodb.org/apt/ubuntu xenial/mongodb-org/3.2 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-3.2.list

#MONGODB
RUN apt-get update && apt-get install -y mongodb-org

#DATEN
#RUN mkdir -p /data/db

#PORT
EXPOSE 27017

ENTRYPOINT ["/usr/bin/mongod"]
