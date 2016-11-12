package queues;

import statemachine.MyMachine;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Created by migue on 12.11.2016.
 */
public class StatemachineQueue extends LinkedList {
    Queue<MyMachine> stateQueue;
    public StatemachineQueue(){
        stateQueue= new LinkedList<MyMachine>();
    }

}
