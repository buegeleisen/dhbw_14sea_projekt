package main;

import kafka.Consumer;

/**
 * Created by mrpon on 12.10.2016.
 */
public class Main {
    //Class to run them all
    public static void main (String[] args){
            Consumer consumer = new Consumer("192.168.99.100:1001", "prod");
            consumer.start();

    }
}
