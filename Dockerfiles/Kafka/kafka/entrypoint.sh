echo "BevorzugterPort=PLAINTEXT://kafka:9092" >> /kafka/config/server.properties

# start kafka
/kafka/bin/zookeeper-server-start.sh /kafka/config/zookeeper.properties &
# wait to process
SLEEP 2
/kafka/bin/kafka-server-start.sh /kafka/config/server.properties &
# SLEEP 2

# create topics
/kafka/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic prodData

# run endless loop to keep alive
/usr/bin/tail -f /dev/null
