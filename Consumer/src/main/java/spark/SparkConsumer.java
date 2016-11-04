package spark;


import objects.Activemqmessage;
import objects.ERPFile;
import objects.KafkaMessage;
import objects.Product;
import scala.util.parsing.combinator.testing.Str;

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

    public void run() {
        while(true){

            Product product;
            KafkaMessage[] kafkaMessage = new KafkaMessage[31];
            ERPFile erpFile;
            //Activemq



            if ((kafkaStringArray != null) && (activemqString != null) && (erpString != null)){

                //kafkaString in ein kafkaMessage-Objekt
                for (int i=0; i<31; i++){

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
                                    kafkaMessage[i].setValue(kafkaStringArray[i].substring(j + 7, comma));
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
                                    kafkaMessage[i].setValue(kafkaStringArray[i].substring(j + 7, comma));
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
                                    kafkaMessage[i].setValue(kafkaStringArray[i].substring(j + 7, comma));
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
                                    kafkaMessage[i].setValue(kafkaStringArray[i].substring(j + 7, bracket));
                                    break;
                                }
                            }
                        }
                    }
                }


                kafkaStringArray=new String[31];
                activemqString=null;
                erpString=null;
            }
        }
    }

}
