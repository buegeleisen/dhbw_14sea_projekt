package statemachine;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import com.github.oxo42.stateless4j.delegates.Action;
import com.google.gson.Gson;
import main.Main;
import objects.KafkaMessage;

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
    public static String Milling_false = "Milling_false";
    public static String Milling_true = "Milling_true";
    public static String Drilling_false = "Drilling_false";
    public static String Drilling_true = "Drilling_true";

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

    public MyMachine(){
        config.configure(preL1).permit(L1_true, preL2);
        config.configure(preL2).permit(L2_true, preMilling);
        config.configure(preMilling).permit(L3_false, Milling);
        config.configure(Milling).permit(Milling_false, preL3);
        config.configure(preL3).permit(L3_true, preDrilling);
        config.configure(preDrilling).permit(L4_false, Drilling);
        config.configure(Drilling).permit(Drilling_false, preL4);
        config.configure(preL4).permit(L4_true, preL5);
        config.configure(preL5).permit(L5_true, finish);
        config.configure(finish).permit(L1_false, preL1);

        stateMachine = new StateMachine<String, String>(preL1, config);
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
}
