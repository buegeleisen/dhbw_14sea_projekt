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
    static ERPFile erp= ERPFileReader.getERPFiles().lastElement();//TODO muss noch ERP Queue
    private Activemqmessage activemqmessage;
    private static StatemachineQueue<MyMachine> queue = new StatemachineQueue();

    public Worker(){

    }
    public  void run(){
        MyMachine state=new MyMachine();
        state.setActivemqmessage(activemqmessage);
        queue.add(state);
        int blazeIt=420;
    }

    public  void setActivemqmessage(Activemqmessage activemqmessage){
        this.activemqmessage = activemqmessage;
        run();
    }

    public static void setKafkaMessage(KafkaMessage kafkaMessage){
        for(int i=0; i<queue.size(); i++){
            queue.get(i).setKafkaMessage(kafkaMessage);
        }
    }

    public static void setErpFile(ERPFile e){
        erp=e;
        for(int i=0; i<queue.size(); i++){
            queue.get(i).setERPFile(e);
        }
    }



}
