package queues;

import statemachine.MyMachine;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Created by migue on 12.11.2016.
 */
public class StatemachineQueue<E> extends LinkedList<E> {


    public StatemachineQueue(){

    }

    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    @Override
    public E get(int index) {
        return super.get(index);
    }

    @Override
    public E poll() {
        return super.poll();
    }
}
