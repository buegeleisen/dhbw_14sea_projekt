package main;

import activemq.ActivemqConsumer;
import filereader.ERPFileReader;
import kafka.Consumer;
import main.Args;

/**
 * Created by mrpon on 12.10.2016.
 */
public class Main {
    //Class to run them all

    public static void main (String[] args){

        Args.setAmqIP(args[0]);
        Args.setKafkaIP(args[1]);
        Args.setObservedPath(args[2]);
        Args.setProcessedPath(args[3]);
        Args.setMeteorIP(args[4]);
        Args.setMeteorPort(args[5]);

        //ActiveMQ Consumer
        Thread activemq = new Thread(new ActivemqConsumer("tcp://"+Args.getAmqIP()));
        activemq.start();

        //FileReader
        ERPFileReader fileReader = new ERPFileReader(Args.getObservedPath(),Args.getProcessedPath());
        Thread fileThread = new Thread(fileReader);
        fileThread.start();

        // Kafka Consumer
        Consumer consumer = new Consumer(Args.getKafkaIP(), "prod");
        consumer.start();




    }
}
