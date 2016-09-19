#Kafka Image 
FROM ubuntu:14.04
RUN apt-get update
RUN useradd kafka -m
RUN sudo apt-get install -y default-jre
RUN sudo apt-get install -y zookeeperd
RUN sudo apt-get install -y wget 
RUN mkdir -p ~/Downloads
RUN wget "http://mirror.cc.columbia.edu/pub/software/apache/kafka/0.8.2.1/kafka_2.11-0.8.2.1.tgz" -O ~/Downloads/kafka.tgz
RUN mkdir -p ~/kafka && cd ~/kafka
RUN tar -xvzf ~/Downloads/kafka.tgz --strip 1
#More to Come

