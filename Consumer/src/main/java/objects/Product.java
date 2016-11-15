package objects;
import java.util.Vector;
/**
 * Created by mrpon on 05.10.2016.
 */
public class Product {
    private ERPFile erpFile;
    private Vector<KafkaMessage>  kafkamessages;
    private Vector<ModifiedMessage> modified;
    private ModifiedMessage machineData;
    private Activemqmessage activemq;
    //Variablen von ActiveMQ


    public Product(ERPFile erpFile, ModifiedMessage machineData, Activemqmessage activemq) {
        this.erpFile = erpFile;
        this.machineData = machineData;
        this.activemq=activemq;
    }

    public ERPFile getErpFile() {
        return erpFile;
    }

    public void setErpFile(ERPFile erpFile) {
        this.erpFile = erpFile;
    }

    public Vector<KafkaMessage> getMessages() {
        return kafkamessages;
    }

    public void setMessages(Vector<KafkaMessage> messages) {
        this.kafkamessages = messages;
    }

    public Activemqmessage getActivemq(){return activemq;}

    public void setActivemq(Activemqmessage activemq){this.activemq=activemq;}
}
