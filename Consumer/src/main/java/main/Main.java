package main;

import kafka.Consumer;
import kafka.message.Message;
import mongoUI.MeteorMapper;
import statemachine.MyMachine;

import java.util.Vector;

/**
 * Created by mrpon on 12.10.2016.
 */
public class Main {
    //Class to run them all
    public static MyMachine myMachine;
    public static MeteorMapper meteorMapper;

    public static void main (String[] args){
        Consumer consumer = new Consumer("192.168.99.100:1001", "prod");
        //test();
      consumer.start();

    }

    private static void test(){
        meteorMapper = new MeteorMapper();
    }
}
