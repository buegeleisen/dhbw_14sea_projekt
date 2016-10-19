package activemq;
import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActivemqConsumer implements Runnable {
    Session session = null;
    Connection connection = null;
    String dest;

    public ActivemqConsumer(String dest) {
        this.dest = dest;
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
                        System.out.println("Received: " + text);
                    } else {
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