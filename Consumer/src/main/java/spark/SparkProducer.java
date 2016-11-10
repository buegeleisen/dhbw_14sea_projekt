package spark;


import com.google.gson.Gson;
import kafka.producer.KeyedMessage;
import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;
import objects.Activemqmessage;
import objects.ERPFile;
import objects.KafkaMessage;
import objects.Product;

import java.util.Date;
import java.util.Properties;
import java.util.Vector;

/**
 * Created by artur.f on 04.11.2016.
 */
public class SparkProducer implements Runnable{

    private static Product product = null;

    private static Vector<KafkaMessage> kafkaMessages= new Vector<KafkaMessage>();
    private static Activemqmessage activemqmessage= null;
    private static ERPFile erp= null;
    private static int zaehler = 0;

    public static void setKafkaMessage(KafkaMessage kafkaMessage){
        zaehler++;
        kafkaMessages.add(kafkaMessage);
        System.out.println("KafkaMessage "+zaehler+":\n"+kafkaMessage.toString());
    }

    public static void setActivemqmessage(Activemqmessage activemqmessage){
        SparkProducer.activemqmessage = activemqmessage;
        System.out.println("ActivemqMessage:\n"+activemqmessage.toString());
    }

    public static void setERPFile(ERPFile erp){
        SparkProducer.erp = erp;
        System.out.println("ERP:\n"+erp.toString());
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
        KeyedMessage<String, String> data = new KeyedMessage<String, String>("spark", "192.168.99.100", message);
        producer.send(data);

    }

    public void run() {

        while (true){

            if (kafkaMessages.size()==31&&activemqmessage!=null&&erp!=null){
                product = new Product(erp, kafkaMessages, activemqmessage);

                Gson gson = new Gson();
                String jsonInString = gson.toJson(product);

                erp=null;
                kafkaMessages= new Vector<KafkaMessage>();
                activemqmessage= null;
                zaehler=0;
            }
        }


    }

}
