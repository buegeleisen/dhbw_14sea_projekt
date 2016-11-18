/**
 * Created by migue on 15.11.2016.
 */
public class Main {
    public static void main(String[] args){
            Consumer consumer = new Consumer("192.168.99.100:1003", "spark");
            consumer.start();

    }
}
