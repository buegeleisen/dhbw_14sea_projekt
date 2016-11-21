#!/bin/bash

#CONSUMER
java -jar Consumer.jar localhost:32768 localhost:1001 ./ERP/ ./ERPp/ localhost 3001
#SIMULATION
java -jar TaktstrasseOpcServer-0.0.1-SNAPSHOT.jar -o ./ERP/ -amqp tcp://localhost:32768 -d 15000 -kafka localhost:1000 -topic prodData -m &

#RUNFOREVER
/usr/bin/tail -f /dev/null