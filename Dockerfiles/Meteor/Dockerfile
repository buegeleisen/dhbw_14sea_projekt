FROM ubuntu:16.04
MAINTAINER Ja.com

#cURL
RUN apt-get update
RUN apt-get install cURL

#ENTRYPOINT
COPY entrypoint.sh /
RUN chmod u+x /entrypoint.sh

#METEOR
RUN curl https://install.meteor.com/ | sh

#ALLEORDNER
RUN mkdir -p /BLABLA

ENTRYPOINT /entrypoint.sh
