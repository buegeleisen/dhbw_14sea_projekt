package statemachine;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import com.github.oxo42.stateless4j.delegates.Action;
import com.google.gson.Gson;
import filereader.ERPFileReader;
import main.Main;
import objects.Activemqmessage;
import objects.ERPFile;
import objects.KafkaMessage;
import objects.Product;
import spark.SparkProducer;

import java.util.Vector;

/**
 * Created by mrpon on 05.10.2016.
 */
public class MyMachine {
    //Trigger
    public static String L1_false = "L1_false";
    public static String L1_true = "L1_true";
    public static String L2_false = "L2_false";
    public static String L2_true = "L2_true";
    public static String L3_false = "L3_false";
    public static String L3_true = "L3_true";
    public static String L4_false = "L4_false";
    public static String L4_true = "L4_true";
    public static String L5_false = "L5_false";
    public static String L5_true = "L5_true";
    public static String MILLING_false = "MILLING_false";
    public static String MILLING_true = "MILLING_true";
    public static String DRILLING_false = "DRILLING_false";
    public static String DRILLING_true = "DRILLING_true";
    public static String DRILLING_HEAT="DRILLING_HEAT";
    public static String DRILLING_SPEED="DRILLING_SPEED";
    public static String MILLING_HEAT="MILLING_HEAT";
    public static String MILLING_SPEED="MILLING_SPEED";

    //States
    public static String preL1 = "preL1";
    public static String preL2 = "preL2";
    public static String preL3 = "preL3";
    public static String preL4 = "preL4";
    public static String preL5 = "preL5";
    public static String Milling = "Milling";
    public static String Drilling = "Drilling";
    public static String preMilling = "preMilling";
    public static String preDrilling = "preDrilling";
    public static String finish = "finish";


    private Gson gson = new Gson();
    private StateMachineConfig<String, String> config = new StateMachineConfig<String, String>();
    private StateMachine<String, String> stateMachine = null;


    private Vector<KafkaMessage> kafkaMessages= new Vector<KafkaMessage>();
    private  Activemqmessage activemqmessage= null;
    private  ERPFile erp;


    public MyMachine(){
        config.configure(preL1).ignore(L1_false);
        config.configure(preL1).permit(L1_true, preL2);
        config.configure(preL2).ignore(L2_false);
        config.configure(preL2).permit(L2_true, preMilling);
        config.configure(preMilling).permit(L3_false, Milling);
        config.configure(Milling).ignore(MILLING_true);
        config.configure(Milling).ignore(MILLING_SPEED);
        config.configure(Milling).ignore(MILLING_HEAT);
        config.configure(Milling).permit(MILLING_false, preL3);
        config.configure(preL3).permit(L3_true, preDrilling);
        config.configure(preDrilling).permit(L4_false, Drilling);
        config.configure(Drilling).ignore(DRILLING_true);
        config.configure(Drilling).ignore(DRILLING_SPEED);
        config.configure(Drilling).ignore(DRILLING_HEAT);
        config.configure(Drilling).permit(DRILLING_false, preL4);
        config.configure(preL4).permit(L4_true, preL5);
        config.configure(preL5).ignore(L5_false);
        config.configure(preL5).permit(L5_true, finish);
        config.configure(finish).permit(L1_false, preL1);

        this.stateMachine = new StateMachine<String, String>(preL1, config);
    }
    public void makeKafkaMessage(String message){
        System.out.println("Statemachine received: "+message);
    }
    public void setKafkaMessage(KafkaMessage kafkaMessage){
        kafkaMessages.add(kafkaMessage);
        if(kafkaMessage.getValue().equals("true") || kafkaMessage.getValue().equals("false")){

            stateMachine.fire(kafkaMessage.getItemName()+"_"+kafkaMessage.getValue());
        }else{
            stateMachine.fire(kafkaMessage.getItemName());
        }
        System.out.println("Aktueller Zustand: "+stateMachine.getState());
        Gson gson= new Gson();
        String kafkaOutput=gson.toJson(kafkaMessage);
        System.out.println(kafkaOutput);
    }
    public  void setActivemqmessage(Activemqmessage activemqmessage){
        this.activemqmessage = activemqmessage;
    }
    public  void setERPFile(ERPFile e){
        if(stateMachine.getState()=="finish"){
            erp=e;
            Product product=new Product(e,kafkaMessages,activemqmessage);
            Gson gson=new Gson();
            String jsonInString=gson.toJson(product);
            System.out.println("Produkt:"+jsonInString);// TODO Product übergeben
        }
    }
    public  ERPFile getERPFile(){
        return erp;
    }
    private void sendToStatemachine(String s){
        KafkaMessage message = gson.fromJson(s, KafkaMessage.class);
        if(message.getValue().equals("true") || message.getValue().equals("false")){
            String trigger = message.getItemName() + "_" +message.getValue();
          //  Main.myMachine.getStateMachine().fire(trigger);
        }
    }


    public StateMachineConfig<String, String> getConfig() {
        return config;
    }

    public StateMachine<String, String> getStateMachine() {
        return stateMachine;
    }

    public void createProduct(ERPFile e, Vector<KafkaMessage> kafkaMessages, Activemqmessage a){
        Product product=new Product(e,kafkaMessages,activemqmessage);
    }
}
