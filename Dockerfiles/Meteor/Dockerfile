FROM ubuntu:16.04

#METEOR
RUN apt-get update
RUN apt-get install -y curl
RUN apt-get install language-pack-en -y
RUN curl https://install.meteor.com/ | sh
RUN apt-get install dos2unix


#UI
COPY /projekt-test-2 /app

#ENTRYPOINT
COPY entrypoint.sh /
RUN dos2unix /entrypoint.sh
RUN chmod +x /entrypoint.sh
#NEUERUSER
RUN useradd -ms /bin/bash meteoruser
RUN chown -cR meteoruser /app
USER meteoruser
WORKDIR /app
RUN meteor npm install
RUN meteor update --patch
RUN meteor reset
ENV PORT 80
ENV MONGO_URL mongodb://database:27017/meteor
ENV ROOT_URL http://127.0.0.1

#PORT
EXPOSE 80

ENTRYPOINT /entrypoint.sh


