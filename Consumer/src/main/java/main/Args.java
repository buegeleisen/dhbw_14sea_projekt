package main;

/**
 * Created by migue on 19.11.2016.
 */
public class Args {
    public static String amqIP;
    public static String kafkaIP;
    public static String observedPath;
    public static String processedPath;
    public static String meteorIP;
    public static int meteorPort;

    public static void setAmqIP(String a){
        amqIP=a;
    }

    public static void setKafkaIP(String k){
        kafkaIP=k;
    }

    public static void setObservedPath(String o){
        observedPath=o;
    }

    public static void setProcessedPath(String p){
        processedPath=p;
    }

    public static void setMeteorIP(String m){
        meteorIP=m;
    }

    public static void setMeteorPort(String port){
        meteorPort=Integer.parseInt(port);
    }

    public static String getAmqIP() {
        return amqIP;
    }

    public static String getKafkaIP() {
        return kafkaIP;
    }

    public static String getObservedPath() {
        return observedPath;
    }

    public static String getProcessedPath() {
        return processedPath;
    }

    public static String getMeteorIP() {
        return meteorIP;
    }

    public static int getMeteorPort() {
        return meteorPort;
    }
}
