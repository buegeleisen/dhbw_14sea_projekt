FROM ubuntu:latest

# Update
RUN apt-get update

# install meteor
RUN apt-get install curl -y
RUN curl https://install.meteor.com/ | sh

#Add User
RUN useradd -ms /bin/bash meteoruser
USER meteoruser
WORKDIR /home/meteoruser

# Create app directory
RUN mkdir -p /home/meteoruser/meteor/
WORKDIR /home/meteoruser/meteor/

# Bundle app source
COPY . /home/meteoruser/meteor/

# Install app dependencies
COPY package.json /home/meteoruser/meteor/
RUN meteor npm install

EXPOSE 3000 3001
CMD [ "meteor"]
