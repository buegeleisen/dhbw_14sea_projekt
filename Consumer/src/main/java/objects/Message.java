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

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }
}
