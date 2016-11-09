package activemq;
import javax.jms.*;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.activemq.ActiveMQConnectionFactory;
import spark.SparkConsumer;

import java.util.Properties;

public class ActivemqConsumer implements Runnable {
    Session session = null;
    Connection connection = null;
    String dest;

    public ActivemqConsumer(String dest) {
        this.dest = dest;
    }

    private void produceStream(String message){
        //Properties für den Producer einrichten
        Properties props = new Properties();

        props.put("metadata.broker.list", "broker1:9090");//9090 ist der Port für der Consumer
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(props);


        //Producer einrichten; Nachricht verschicken
        Producer<String, String> producer = new Producer<String, String>(config);
        String ip;
        KeyedMessage<String, String> data = new KeyedMessage<String, String>("spark", "192.168.99.100", message);
        producer.send(data);

    }


    public void run() {
        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(dest);

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic)
            Destination destination = session.createTopic("m_orders");

            // Create a MessageConsumer from the Session to the Topic
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        String text = "";
                        try {
                            text = textMessage.getText();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                        SparkConsumer.getActivemqString(text);
                        //durch den Producer
                        produceStream(text);
                        System.out.println("Received: " + text);
                    } else {
                        SparkConsumer.getActivemqString(message.toString());
                        //durch den Producer
                        produceStream(message.toString());
                        System.out.println("Received: " + message);
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        } finally {
            try {
                if (session != null)
                    session.close();
                if (connection != null)
                    connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }


}