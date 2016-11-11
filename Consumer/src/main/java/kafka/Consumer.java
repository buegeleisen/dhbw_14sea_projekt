package kafka;

import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.gson.Gson;
import kafka.consumer.ConsumerConfig;

import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import main.Main;
import objects.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import org.apache.kafka.common.serialization.StringDeserializer;
import spark.SparkProducer;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Consumer extends AbstractExecutionThreadService {

    private String topicName;
    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    private ConsumerConfig consumerConfig;

    private static final String BOOTSTRAP_SERVERS = "bootstrap.servers";
    private static final String CONNECT_ZOOKEEPER = "zookeeper.connect";
    private static final String GROUP_ID = "group.id";
    private static final String CLIENT_ID = "client.id";
    private static final String KEY_DESERIALIZE = "key.deserializer";
    private static final String VALUE_DESERIALIZE = "value.deserializer";
    private static final String PARTITION = "partition.assignment.strategy";

    private Gson gson = new Gson();


    public Consumer(String server, String topicName){
        //BasicConfigurator.configure();
        Properties properties = new Properties();
        putProperties(properties, server);
        this.consumerConfig = new ConsumerConfig(properties);
        this.topicName = topicName;
    }

    private void putProperties(Properties properties, String server) {
        properties.put(BOOTSTRAP_SERVERS, server);
        properties.put(CONNECT_ZOOKEEPER, server);
        properties.put(GROUP_ID, "xyz");
        properties.put(CLIENT_ID,this.getClass().getSimpleName());
        properties.put(KEY_DESERIALIZE, StringDeserializer.class.getName());
        properties.put(VALUE_DESERIALIZE, StringDeserializer.class.getName());
        properties.put(PARTITION, "range");
    }

    public void run() {
        logger.info("Starting the kafka.Consumer...");

        ConsumerConnector connector = kafka.consumer.Consumer.createJavaConsumerConnector(consumerConfig);
        Map<String, List<KafkaStream<byte[], byte[]>>> messages = connector.createMessageStreams(ImmutableMap.of(topicName, 1));
        List<KafkaStream<byte[], byte[]>> messageStreams = messages.get(topicName);
        ExecutorService executorService = Executors.newFixedThreadPool(messageStreams.size());

        for (final KafkaStream<byte[], byte[]> messageStream : messageStreams) {
            executorService.submit(new Runnable() {
                public void run(){
                    for (MessageAndMetadata<byte[], byte[]> messageAndMetadata : messageStream) {
                        String message = new String(messageAndMetadata.message());
                        Gson gson= new Gson();
                        KafkaMessage kafkaMessage = gson.fromJson(message, KafkaMessage.class);
                        SparkProducer.setKafkaMessage(kafkaMessage);System.out.println("1");

                        // to spark and Statemachine

                        logger.info("Received: {}", message);
                    }
                }
            });
        }

    }




}