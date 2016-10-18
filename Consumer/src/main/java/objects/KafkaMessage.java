package objects;

import java.math.BigInteger;

/**
 * Created by mrpon on 05.10.2016.
 */
public class KafkaMessage {
    private String value;
    private String status;
    private String itemName;
    private BigInteger timestamp;

    public KafkaMessage(String value, String status, String itemName, BigInteger timestamp){
        this.value = value;
        this.status = status;
        this.itemName = itemName;
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
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
