package queues;
import objects.ERPFile;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by migue on 12.11.2016.
 */
public class ERPQueue extends LinkedList{
    Queue<ERPFile> erpFileQueue;
    public ERPQueue(){
        erpFileQueue=new LinkedList<ERPFile>();
    }
}
