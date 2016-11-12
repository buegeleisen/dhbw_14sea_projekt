package worker;

import filereader.ERPFileReader;
import objects.Activemqmessage;
import objects.ERPFile;
import objects.KafkaMessage;
import queues.StatemachineQueue;
import statemachine.MyMachine;

import java.util.Vector;

/**
 * Created by migue on 12.11.2016.
 */
public class Worker {
    ERPFile erp= ERPFileReader.getERPFiles().lastElement();//TODO muss noch ERP Queue
    private static Activemqmessage activemqmessage;
    private static KafkaMessage kafka;
    private static StatemachineQueue queue;
    private static Vector<KafkaMessage> kafkaMessages=new Vector<KafkaMessage>();

    public Worker(){
        queue= new StatemachineQueue();
    }
    public static void run(){
        MyMachine state=new MyMachine();
        state.setActivemqmessage(activemqmessage);
        queue.add(state);

    }

    public static void setActivemqmessage(Activemqmessage activemqmessage){
        Worker.activemqmessage = activemqmessage;
    }
    public static void setKafkaMessage(KafkaMessage kafkaMessage){
        Worker.kafka=kafkaMessage;
        
    }



}
