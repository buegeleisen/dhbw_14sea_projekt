package objects;

import java.math.BigInteger;

/**
 * Created by mrpon on 05.10.2016.
 */
public class Message {
    private boolean value;
    private String status;
    private String itemName;
    private BigInteger timestamp;

    public Message(boolean value, String status, String itemName, BigInteger timestamp){
        this.value = value;
        this.status = status;
        this.itemName = itemName;
        this.timestamp = timestamp;
    }
}
