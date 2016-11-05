package spark;


import objects.Activemqmessage;
import objects.ERPFile;
import objects.KafkaMessage;
import objects.Product;

import java.math.BigInteger;
import java.util.Vector;

/**
 * Created by artur.f on 04.11.2016.
 */
public class SparkConsumer implements Runnable{

    private static String[] kafkaStringArray = new String[31];
    private static String activemqString;
    private static String erpString;

    private static Vector<Product> allProducts;

    public static void getKafkaString(String kafkaString){
        for (int i=0; i<31; i++) {
            if (kafkaStringArray[i] == null){
                kafkaStringArray[i] = activemqString;
            }
        }
    }

    public static void getActivemqString(String activemqString){
        SparkConsumer.activemqString = activemqString;
    }

    public static void getERPFileString(String erpString){
        SparkConsumer.erpString = erpString;
    }




    //kafkaString in ein kafkaMessage-Objekt
    private Vector<KafkaMessage> kafkaMessagesForProduct(Vector<KafkaMessage> kafkaMessages){
        for (int i=0; i<31; i++){

            KafkaMessage naechsteMessage = null;
            String value = null;
            String status = null;
            String itemName = null;
            BigInteger timestamp = null;

            //value
            //Jedes Zeichen in der Kafkamessage...
            for (int j=0; j<kafkaStringArray[i].length()-5; j++){
                int comma;
                //...wird nach dem Begriff "value" durchsucht...
                if (kafkaStringArray[i].substring(j, j+5).equals("value")){
                    //... und nach dem Komma dahinter
                    for (int k=j+7; k<kafkaStringArray[i].length();k++){
                        if (kafkaStringArray[i].substring(k, k+1).equals(",")) {
                            comma=k;
                            value=kafkaStringArray[i].substring(j + 7, comma);
                            break;
                        }
                    }
                }
            }

            //status
            //Jedes Zeichen in der Kafkamessage...
            for (int j=0; j<kafkaStringArray[i].length()-6; j++){
                int comma;
                //...wird nach dem Begriff "status" durchsucht...
                if (kafkaStringArray[i].substring(j, j+6).equals("status")){
                    //... und nach dem Komma dahinter
                    for (int k=j+9; k<kafkaStringArray[i].length();k++){
                        if (kafkaStringArray[i].substring(k, k+1).equals(",")) {
                            comma=k;
                            status=kafkaStringArray[i].substring(j + 7, comma);
                            break;
                        }
                    }
                }
            }

            //itemName
            //Jedes Zeichen in der Kafkamessage...
            for (int j=0; j<kafkaStringArray[i].length()-8; j++){
                int comma;
                //...wird nach dem Begriff "itemName" durchsucht...
                if (kafkaStringArray[i].substring(j, j+8).equals("itemName")){
                    //... und nach dem Komma dahinter
                    for (int k=j+11; k<kafkaStringArray[i].length();k++){
                        if (kafkaStringArray[i].substring(k, k+1).equals(",")) {
                            comma=k;
                            itemName=kafkaStringArray[i].substring(j + 7, comma);
                            break;
                        }
                    }
                }
            }

            //timeStamp
            //Jedes Zeichen in der Kafkamessage...
            for (int j=0; j<kafkaStringArray[i].length()-9; j++){
                int bracket;
                //...wird nach dem Begriff "timeStamp" durchsucht...
                if (kafkaStringArray[i].substring(j, j+9).equals("timeStamp")){
                    //... und nach der geschweiften Klammer dahinter
                    for (int k=j+11; k<kafkaStringArray[i].length();k++){
                        if (kafkaStringArray[i].substring(k, k+1).equals("}")) {
                            bracket=k;
                            timestamp=new BigInteger(kafkaStringArray[i].substring(j + 7, bracket));
                            break;
                        }
                    }
                }
            }

            naechsteMessage.setValue(value);
            naechsteMessage.setStatus(status);
            naechsteMessage.setItemName(itemName);
            naechsteMessage.setTimestamp(timestamp);
            kafkaMessages.add(naechsteMessage);
        }


        return kafkaMessages;

    }

    private Activemqmessage activemqmessageForProduct(String activemqString){

        Activemqmessage activemqmessage = null;
        int customernumber=0;
        int materialnumber=0;
        String ordernumber=null;
        String timestamp=null;

        int length= activemqString.length();

        //costumerNumber
        for (int i=0; i<length; i++){
            if (activemqString.substring(i, i+16).equals("<customerNumber>")){
                customernumber=Integer.parseInt(activemqString.substring(i+16, i+20));
                break;
            }
        }
        //matarialnumber
        for (int i=0; i<length; i++){
            if (activemqString.substring(i, i+16).equals("<materialNumber>")){
                materialnumber=Integer.parseInt(activemqString.substring(i+16, i+20));
                break;
            }
        }
        //ordernumber
        for (int i=0; i<length; i++){
            if (activemqString.substring(i, i+13).equals("<orderNumber>")){
                ordernumber=activemqString.substring(i+13, i+49);
                break;
            }
        }
        //timestamp
        for (int i=0; i<length; i++){
            if (activemqString.substring(i, i+11).equals("<timestamp>")){
                timestamp=activemqString.substring(i+11, i+40);
                break;
            }
        }

        //Attribute ins ActivemqMessage-Object
        activemqmessage.setCustomernumber(customernumber);
        activemqmessage.setMaterialnumber(materialnumber);
        activemqmessage.setOrdernumber(ordernumber);
        activemqmessage.setTimestamp(timestamp);


        return activemqmessage;

    }

    public void run() {
        while(true){

            Product product = null;
            Vector<KafkaMessage> kafkaMessages= new Vector<KafkaMessage>();
            //erp ist noch nicht gemappt


            if ((kafkaStringArray != null) && (activemqString != null) && (erpString != null)){

                //kafkaMessage und ActivemqMessage ins Produkt
                //TODO: erp fehlt noch. Ich kapier noch nicht genug in welcher Form es kommt. Gruß Artur
                kafkaMessages = kafkaMessagesForProduct(kafkaMessages);
                Activemqmessage activemqmessage= activemqmessageForProduct(activemqString);
                //erp

                product.setMessages(kafkaMessages);
                product.setActivemq(activemqmessage);

                kafkaStringArray=new String[31];
                activemqString=null;
                erpString=null;
            }

        }
    }

}
