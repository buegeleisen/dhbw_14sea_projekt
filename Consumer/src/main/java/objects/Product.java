package objects;
import java.util.Vector;
/**
 * Created by mrpon on 05.10.2016.
 */
public class Product {
    private ERPFile erpFile;
    private Vector<KafkaMessage>  messages;
    private Activemqmessage activemq;
    //Variablen von ActiveMQ


    public Product(ERPFile erpFile, Vector<KafkaMessage> messages, Activemqmessage activemq) {
        this.erpFile = erpFile;
        this.messages = messages;
        this.activemq=activemq;
    }

    public ERPFile getErpFile() {
        return erpFile;
    }

    public void setErpFile(ERPFile erpFile) {
        this.erpFile = erpFile;
    }

    public Vector<KafkaMessage> getMessages() {
        return messages;
    }

    public void setMessages(Vector<KafkaMessage> messages) {
        this.messages = messages;
    }

    public Activemqmessage getActivemq(){return activemq;}

    public void setActivemq(Activemqmessage activemq){this.activemq=activemq;}
}
