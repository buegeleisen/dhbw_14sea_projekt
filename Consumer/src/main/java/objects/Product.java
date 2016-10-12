package objects;

/**
 * Created by mrpon on 05.10.2016.
 */
public class Product {
    private ERPFile erpFile;
    private KafkaMessage[] messages;
    //Variablen von ActiveMQ


    public Product(ERPFile erpFile, KafkaMessage[] messages) {
        this.erpFile = erpFile;
        this.messages = messages;
    }

    public ERPFile getErpFile() {
        return erpFile;
    }

    public void setErpFile(ERPFile erpFile) {
        this.erpFile = erpFile;
    }

    public KafkaMessage[] getMessages() {
        return messages;
    }

    public void setMessages(KafkaMessage[] messages) {
        this.messages = messages;
    }
}
