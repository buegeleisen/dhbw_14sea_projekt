package worker;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

/**
 * Created by migue on 15.11.2016.
 */
public class Producer {
   public Producer(){
       Properties props = new Properties();
       props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
       props.put("bootstrap.servers", "192.168.99.100:1002");
       props.put("metadata.broker.list","192.168.99.100:1002");
       org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<String, String>(props);
   }
}
