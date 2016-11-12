package activemq;
import javax.jms.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import objects.Activemqmessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import spark.SparkProducer;
import statemachine.MyMachine;
import worker.Worker;

import java.io.StringReader;
import java.util.Properties;

public class ActivemqConsumer implements Runnable {
    Session session = null;
    Connection connection = null;
    String dest;

    public ActivemqConsumer(String dest) {
        this.dest = dest;
    }

    private Activemqmessage xmlToActivemq(String xml){
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Activemqmessage.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            Activemqmessage activemqmessage = (Activemqmessage) unmarshaller.unmarshal(reader);
            return activemqmessage;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
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
                        SparkProducer.setActivemqmessage(xmlToActivemq(text));
                        Worker.setActivemqmessage(xmlToActivemq(text));
                        Worker.run();
                        System.out.println("Received: " + text);
                    } else {
                        SparkProducer.setActivemqmessage(xmlToActivemq(message.toString()));
                        Worker.setActivemqmessage(xmlToActivemq(message.toString()));
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