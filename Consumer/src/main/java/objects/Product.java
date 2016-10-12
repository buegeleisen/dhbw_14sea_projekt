package objects;

/**
 * Created by mrpon on 05.10.2016.
 */
public class Product {
    private ERPFile erpFile;
    private Message[] messages;
    //Variablen von ActiveMQ


    public Product(ERPFile erpFile, Message[] messages) {
        this.erpFile = erpFile;
        this.messages = messages;
    }

    public ERPFile getErpFile() {
        return erpFile;
    }

    public void setErpFile(ERPFile erpFile) {
        this.erpFile = erpFile;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
}
