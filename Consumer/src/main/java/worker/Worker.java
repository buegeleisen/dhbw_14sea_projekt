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
    public static StatemachineQueue<MyMachine> queue = new StatemachineQueue();
    public static int id=1;
    public Worker(){

    }
    public static void init(Activemqmessage activemqmessage){
        MyMachine state=new MyMachine(id);
        id++;
        System.out.println("Worker: Statemachine gestartet!");
        state.setActivemqmessage(activemqmessage);
        queue.add(state);
        //System.out.println("Worker: Queuesize:"+ queue.size());
        int blazeIt=420;
    }

    /*public  static void setActivemqmessage(Activemqmessage activemqmessage){
        Worker.activemqmessage = activemqmessage;
        run();
    }*/
    public static void distributeKafkaMessage(String message){
        System.out.println("Worker: Received kafkamessage:"+message);
        for(int i=0; i<queue.size(); i++){
            queue.get(i).makeKafkaMessage(message);
        }
    }
    public static void setKafkaMessage(KafkaMessage kafkaMessage){ //TODO vll neue Methode mit der message. Denn hier hängts :(
        for(int i=0; i<queue.size(); i++){
            if(queue.get(i).getStateMachine().getState().equals("finish")){
            }else{
                queue.get(i).setKafkaMessage(kafkaMessage);
            }
            //System.out.println("Worker is getting kafkamessage with value:"+kafkaMessage.getValue());
        }

    }
    public static void sendKafkaToUI(KafkaMessage kafkaMessage){

    }
    public static void setErpFile(ERPFile e){
        for(int i=0; i<queue.size(); i++){


                queue.get(i).setERPFile(e);

        }
    }



}
