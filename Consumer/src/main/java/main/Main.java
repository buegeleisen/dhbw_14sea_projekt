package main;

import activemq.ActivemqConsumer;
import filereader.ERPFileReader;
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

    public static void main (String[] args){
        //ActiveMQ Consumer
        Thread activemq = new Thread(new ActivemqConsumer("tcp://localhost:32780"));
        activemq.start();

        //FileReader
        ERPFileReader fileReader = new ERPFileReader(args[0],args[1]);
        Thread fileThread = new Thread(fileReader);
        fileThread.start();

        // Kafka Consumer
        Consumer consumer = new Consumer("192.168.99.100:1001", "prod");
        consumer.start();

    }
}
